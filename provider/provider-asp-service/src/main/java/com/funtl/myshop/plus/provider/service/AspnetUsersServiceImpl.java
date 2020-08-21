package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.AspnetUsers;
import com.funtl.myshop.plus.provider.dto.RoleList;
import com.funtl.myshop.plus.provider.mapper.AspnetUsersMapper;
import com.funtl.myshop.plus.provider.api.AspnetUsersService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class AspnetUsersServiceImpl implements AspnetUsersService{

    @Resource
    private AspnetUsersMapper aspnetUsersMapper;


    @Override
    public List<RoleList> selectByUserAuto(Long userAuto) {
        return aspnetUsersMapper.selectByUserAuto(userAuto);
    }

    @Override
    public AspnetUsers selectByAppId(Object applicationId, Object userId) {
        Example example = new Example(AspnetUsers.class);
        example.createCriteria().andEqualTo("applicationId",applicationId)
                .andEqualTo("userId",userId);
        return aspnetUsersMapper.selectOneByExample(example);
    }
}
