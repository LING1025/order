package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.TripDetailList;
import com.funtl.myshop.plus.provider.mapper.RptVstFlowMapper;
import com.funtl.myshop.plus.provider.domain.RptVstFlow;
import com.funtl.myshop.plus.provider.api.RptVstFlowService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class RptVstFlowServiceImpl implements RptVstFlowService{

    @Resource
    private RptVstFlowMapper rptVstFlowMapper;


    @Override
    public List<TripDetailList> selectByRptVstAuto(Long rptVstAuto) {
        return rptVstFlowMapper.selectByRptVstAuto(rptVstAuto);
    }
}
