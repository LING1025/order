package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.LoginInfo;
import com.funtl.myshop.plus.business.dto.LoginParam;
import com.funtl.myshop.plus.business.feign.UserFeign;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.commons.utils.MapperUtils;
import com.funtl.myshop.plus.commons.utils.OkHttpClientUtil;
import com.funtl.myshop.plus.provider.api.AspnetRolesService;
import com.funtl.myshop.plus.provider.api.AspnetUsersService;
import com.funtl.myshop.plus.provider.domain.AspnetRoles;
import com.funtl.myshop.plus.provider.domain.AspnetUsers;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import okhttp3.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/**
 * 登录管理
 */

@RestController
public class LoginController {
    private static final String URL_OAUTH_TOKEN = "http://localhost:9081/oauth/token";

    @Value("${business.oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${business.oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${business.oauth2.client_secret}")
    public String oauth2ClientSecret;

    @Resource(name = "userDetailsServiceBean")
    public UserDetailsService userDetailsService;

    @Resource
    public BCryptPasswordEncoder passwordEncoder;

    @Resource
    public TokenStore tokenStore;

    @Reference(version = "1.0.0")
    private AspnetUsersService aspnetUsersService;

    @Reference(version = "1.0.0")
    private AspnetRolesService aspnetRolesService;

    @Resource
    private UserFeign userFeign;

    /**
     * 登录
     *
     * @param loginParam 登录参数
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "/user/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam) {
        // 封装返回的结果集
        Map<String, Object> result = Maps.newHashMap();

        // 验证密码是否正确
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (userDetails == null) {
            return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.ILLEGAL_REQUEST, "用户不存在", null);
        }
        if (userDetails != null && !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.ILLEGAL_REQUEST, "密码错误", null);
        }

        // 通过 HTTP 客户端请求登录接口
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);

        try {
            // 解析响应结果封装并返回
            Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params);
            String jsonString = Objects.requireNonNull(response.body()).string();
            Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            result.put("tokenCode", token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.OK, "登录成功", result);
    }

    /**
     * 获取用户信息
     *
     * @return {@link ResponseResult}
     */
    @GetMapping(value = "/user/info")
    public ResponseResult<LoginInfo> info(HttpServletRequest request) throws Exception {
        // 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 获取个人信息
        String jsonString = userFeign.info(authentication.getName());
        AspnetUsers aspnetUsers = MapperUtils.json2pojoByTree(jsonString,"data",AspnetUsers.class);
        if(aspnetUsers == null){
            return MapperUtils.json2pojo(jsonString, ResponseResult.class);
        }

        AspnetUsers au = aspnetUsersService.selectById(aspnetUsers.getUserAuto());

        //获取角色
        List<AspnetRoles> list = aspnetRolesService.selectByUserId(au.getUserId());
        List<Long> ids = Lists.newArrayList();
        for(AspnetRoles aspnetRoles : list){
            ids.add(aspnetRoles.getRolesAuto());
        }

        // 封装并返回结果
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(aspnetUsers.getUsername());
        loginInfo.setUserAuto(aspnetUsers.getUserAuto());
        loginInfo.setRoleAutos(ids);
        return new ResponseResult<LoginInfo>(ResponseResult.CodeStatus.OK, "获取用户信息", loginInfo);
    }


    /**
     * 注销
     *
     * @return {@link ResponseResult}
     */
    @PostMapping(value = "/user/logout")
    public ResponseResult<Void> logout(HttpServletRequest request) {
        // 获取 token
        String token = request.getParameter("access_token");
        // 删除 token 以注销
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "用户已注销");
    }
}
