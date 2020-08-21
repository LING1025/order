package com.funtl.myshop.plus.business.service;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.AspnetUsersService;
import com.funtl.myshop.plus.provider.api.WxEncryptedDataService;
import com.funtl.myshop.plus.provider.domain.AspnetUsers;
import com.funtl.myshop.plus.provider.domain.WxEncryptedData;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

// 优化了认证逻辑
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "$2a$10$WhCuqmyCsYdqtJvM0/J4seCU.xZQHe2snNE5VFUuBGUZWPbtdl3GG";

    @Reference(version = "1.0.0")
    private AspnetUsersService aspnetUsersService;

    @Reference(version = "1.0.0")
    private WxEncryptedDataService wxEncryptedDataService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询用户
        /*AspnetUsers aspnetUsers = aspnetUsersService.get(s);
        if(aspnetUsers == null){
            return null;
        }*/

        //根据openId查询用户
        WxEncryptedData wxEncryptedData = wxEncryptedDataService.getOpenId(s);
        if(wxEncryptedData == null || wxEncryptedData.getUserAuto() == null || wxEncryptedData.getUsername() == null){
            return null;
        }

        // 默认所有用户拥有 USER 权限
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(grantedAuthority);
        // 用户存在
        /*if (aspnetUsers != null) {
            return new User(aspnetUsers.getUsername(),"$2a$10$/GjKa/yU7Y8SjZ6YGSa0ye7Zk118PNrVcpH32HcXaHrKBHTN2/qay", grantedAuthorities);
        }*/

        // 用户存在
        if (wxEncryptedData != null && wxEncryptedData.getUserAuto() != null && wxEncryptedData.getUsername() != null) {
            return new User(wxEncryptedData.getOpenId(),"$2a$10$/GjKa/yU7Y8SjZ6YGSa0ye7Zk118PNrVcpH32HcXaHrKBHTN2/qay", grantedAuthorities);
        }

        // 用户不存在
        else {
            return null;
        }
    }


}
