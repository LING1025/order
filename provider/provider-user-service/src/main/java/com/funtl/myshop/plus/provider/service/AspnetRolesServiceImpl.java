package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.AspnetRolesMapper;
import com.funtl.myshop.plus.provider.domain.AspnetRoles;
import com.funtl.myshop.plus.provider.api.AspnetRolesService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class AspnetRolesServiceImpl implements AspnetRolesService{

    @Resource
    private AspnetRolesMapper aspnetRolesMapper;


    @Override
    public List<AspnetRoles> selectByUserId(Object userId) {
        return aspnetRolesMapper.selectByUserId(userId);
    }
}