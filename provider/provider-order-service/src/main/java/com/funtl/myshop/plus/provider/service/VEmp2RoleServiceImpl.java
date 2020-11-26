package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.FNameSelect;
import com.funtl.myshop.plus.provider.domain.OrgNameSelect;
import com.funtl.myshop.plus.provider.domain.VEmp2Role;
import com.funtl.myshop.plus.provider.mapper.VEmp2RoleMapper;
import com.funtl.myshop.plus.provider.api.VEmp2RoleService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class VEmp2RoleServiceImpl implements VEmp2RoleService{

    @Resource
    private VEmp2RoleMapper vEmp2RoleMapper;


    @Override
    public List<OrgNameSelect> selectOrgName(Long userAuto) {
        return vEmp2RoleMapper.selectOrgName(userAuto);
    }

    @Override
    public List<FNameSelect> selectFName(String roleName, Long orgAuto) {
        return vEmp2RoleMapper.selectFName(roleName,orgAuto);
    }
}
