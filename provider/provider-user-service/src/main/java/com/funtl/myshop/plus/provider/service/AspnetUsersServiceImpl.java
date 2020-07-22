package com.funtl.myshop.plus.provider.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.AspnetUsers;
import com.funtl.myshop.plus.provider.mapper.AspnetUsersMapper;
import com.funtl.myshop.plus.provider.api.AspnetUsersService;
import tk.mybatis.mapper.entity.Example;

@Service
public class AspnetUsersServiceImpl implements AspnetUsersService{

    @Resource
    private AspnetUsersMapper aspnetUsersMapper;

    @Override
    public AspnetUsers get(String username) {
        Example example = new Example(AspnetUsers.class);
        example.createCriteria().andEqualTo("username",username).andEqualTo("applicationId","73663109-DDA2-4C2D-8311-337946B5C373");
        return aspnetUsersMapper.selectOneByExample(example);
    }
}
