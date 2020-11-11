package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.TripQueryParam;
import com.funtl.myshop.plus.provider.mapper.RptVstMapper;
import com.funtl.myshop.plus.provider.api.RptVstService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class RptVstServiceImpl implements RptVstService{

    @Resource
    private RptVstMapper rptVstMapper;

    @Override
    public List<TripRecorderList> selectByTrip(TripQueryParam tripQueryParam) {
        return rptVstMapper.selectByTrip(tripQueryParam);
    }

    @Override
    public List<TripRecorderList> selectByTripTwo(TripQueryParam tripQueryParam) {
        return rptVstMapper.selectByTripTwo(tripQueryParam);
    }

    @Override
    public List<CrmTripList> selectCrmTripList(Integer userAuto, String customerName) {
        return rptVstMapper.selectCrmTripList(userAuto,customerName);
    }

    @Override
    public CrmDetail selectByRptVstAuto(Long rptVstAuto) {
        return rptVstMapper.selectByRptVstAuto(rptVstAuto);
    }

    @Override
    public Integer update(RptVst rptVst) {
        return rptVstMapper.updateByPrimaryKeySelective(rptVst);
    }

    @Override
    public List<CrmSelect> selectByTradeItemAuto(Long tradeItemAuto, Integer type) {
        return rptVstMapper.selectByTradeItemAuto(tradeItemAuto,type);
    }

}
