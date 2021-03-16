package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.VEmpService;
import com.funtl.myshop.plus.provider.domain.AgentList;
import com.funtl.myshop.plus.provider.domain.CarApplyList;
import com.funtl.myshop.plus.provider.domain.CarApplyOrg;
import com.funtl.myshop.plus.provider.domain.VEmp;
import com.funtl.myshop.plus.provider.mapper.VEmpMapper;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service(version = "1.0.0")
public class VEmpServiceImpl implements VEmpService {

    @Resource
    private VEmpMapper vEmpMapper;

    @Override
    public List<CarApplyList> selectCarApply(Long orgAuto) {
        return vEmpMapper.selectCarApply(orgAuto);
    }

    @Override
    public List<CarApplyOrg> selectCarApplyOrg(Long userAuto) {
        return vEmpMapper.selectCarApplyOrg(userAuto);
    }

    @Override
    public VEmp selectByUserAuto(Long userAuto) {
        Example example = new Example(VEmp.class);
        example.createCriteria().andEqualTo("userAuto",userAuto)
                .andEqualTo("isOn",1);
        return vEmpMapper.selectOneByExample(example);
    }

    @Override
    public List<AgentList> selectAgentList(Long agentUser) {
        return vEmpMapper.selectAgentList(agentUser);
    }
}
