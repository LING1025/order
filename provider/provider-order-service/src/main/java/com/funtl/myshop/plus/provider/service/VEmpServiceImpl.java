package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.SaleNameSelect;
import com.funtl.myshop.plus.provider.mapper.VEmpMapper;
import com.funtl.myshop.plus.provider.domain.VEmp;
import com.funtl.myshop.plus.provider.api.VEmpService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(version = "1.0.0")
public class VEmpServiceImpl implements VEmpService{

    @Resource
    private VEmpMapper vEmpMapper;

    @Override
    public VEmp selectByUserAuto(Long userAuto) {
        Example example = new Example(VEmp.class);
        example.createCriteria().andEqualTo("userAuto",userAuto)
        .andEqualTo("isOn",1);
        return vEmpMapper.selectOneByExample(example);
    }

    @Override
    public List<SaleNameSelect> selectSaleName(Long salesAuto, String saleName) {
        return vEmpMapper.selectSaleName(salesAuto,saleName);
    }

}
