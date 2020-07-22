package com.funtl.myshop.plus.provider.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.AspnetUsers;
import com.funtl.myshop.plus.provider.mapper.AspnetUsersMapper;
import com.funtl.myshop.plus.provider.api.AspnetUsersService;
@Service
public class AspnetUsersServiceImpl implements AspnetUsersService{

    @Resource
    private AspnetUsersMapper aspnetUsersMapper;

}
