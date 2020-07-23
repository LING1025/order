package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.UserDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.AspnetUsersService;
import com.funtl.myshop.plus.provider.domain.AspnetUsers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户信息管理相关操作")
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Reference(version = "1.0.0")
    private AspnetUsersService aspnetUsersService;

    @ApiOperation(value = "获取个人信息")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "path")
    @GetMapping(value = "info/{username}")
    public ResponseResult<UserDto> info(@PathVariable String username){
        AspnetUsers aspnetUsers = aspnetUsersService.get(username);
        if(aspnetUsers == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"用户不存在",null);
        }
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(aspnetUsers,userDto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"获取个人信息",userDto);
    }
}
