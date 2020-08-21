package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.AspnetUsers;
import com.funtl.myshop.plus.provider.mapper.AspnetUsersMapper;
import com.funtl.myshop.plus.provider.api.AspnetUsersService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class AspnetUsersServiceImpl implements AspnetUsersService{

    @Resource
    private AspnetUsersMapper aspnetUsersMapper;


}
