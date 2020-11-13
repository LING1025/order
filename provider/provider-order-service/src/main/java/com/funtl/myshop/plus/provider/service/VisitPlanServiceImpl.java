package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.AddressList;
import com.funtl.myshop.plus.provider.mapper.VisitPlanMapper;
import com.funtl.myshop.plus.provider.domain.VisitPlan;
import com.funtl.myshop.plus.provider.api.VisitPlanService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class VisitPlanServiceImpl implements VisitPlanService{

    @Resource
    private VisitPlanMapper visitPlanMapper;

    @Override
    public List<AddressList> selectByType(Integer type,Long code) {
        return visitPlanMapper.selectByType(type,code);
    }
}
