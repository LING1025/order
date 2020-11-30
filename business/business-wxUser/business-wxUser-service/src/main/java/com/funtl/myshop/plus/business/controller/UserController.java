package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.UserDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.VEmpService;
import com.funtl.myshop.plus.provider.api.WxEncryptedDataService;
import com.funtl.myshop.plus.provider.domain.SaleOpenIdList;
import com.funtl.myshop.plus.provider.domain.VEmp;
import com.funtl.myshop.plus.provider.domain.WxEncryptedData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户信息管理相关操作")
@RestController
@RequestMapping(value = "wxUser")
public class UserController {

    @Reference(version = "1.0.0")
    private WxEncryptedDataService wxEncryptedDataService;

    @Reference(version = "1.0.0")
    private VEmpService vEmpService;

    @ApiOperation(value = "获取微信个人信息")
    @ApiImplicitParam(name = "openId", value = "openId", required = true, dataType = "string", paramType = "path")
    @GetMapping(value = "wxInfo/{openId}")
    public ResponseResult<UserDto> wxInfo(@PathVariable String openId){
        WxEncryptedData wxEncryptedData = wxEncryptedDataService.getOpenId(openId);
        if(wxEncryptedData == null || wxEncryptedData.getUserAuto() == null || wxEncryptedData.getUsername() == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"该用户没有使用权限",null);
        }
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(wxEncryptedData,userDto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"获取个人信息",userDto);
    }

    @ApiOperation(value = "小程序已授权用户数据")
    @GetMapping(value = "querySaleOpenId")
    public ResponseResult<List<SaleOpenIdList>> querySaleOpenId(){
        List<SaleOpenIdList> lists = wxEncryptedDataService.selectSaleOpenId();
        for (SaleOpenIdList saleOpenIdList : lists){
            VEmp vEmp = vEmpService.selectByUserAuto(saleOpenIdList.getSalesAuto());
            saleOpenIdList.setSaleName(vEmp.getFName());
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }
}
