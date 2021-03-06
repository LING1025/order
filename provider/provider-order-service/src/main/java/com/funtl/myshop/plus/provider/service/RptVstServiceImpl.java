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
    public CrmDetail selectByRptVstAuto(Long rptVstAuto,String contName) {
        return rptVstMapper.selectByRptVstAuto(rptVstAuto,contName);
    }

    @Override
    public Integer update(RptVst rptVst) {
        return rptVstMapper.updateByPrimaryKeySelective(rptVst);
    }

    @Override
    public List<CustomerNameSelect> selectByFName(String fName,Long salesAuto) {
        return rptVstMapper.selectByFName(fName,salesAuto);
    }

    @Override
    public List<ContNameSelect> selectByTradeItemAuto(Long tradeItemAuto,String contName) {
        return rptVstMapper.selectByTradeItemAuto(tradeItemAuto,contName);
    }

    @Override
    public List<CrmItemNameSelect> selectByTypes(Integer types,Integer num) {
        return rptVstMapper.selectByTypes(types,num);
    }

    @Override
    public Long insert(RptVst rptVst) {
        Integer i = rptVstMapper.insertUseGeneratedKeys(rptVst);
        return i == 1 ? rptVst.getRptVstAuto() : 0;
    }

    @Override
    public Integer deleteByRptVstId(Long rptVstAuto) {
        return rptVstMapper.deleteByPrimaryKey(rptVstAuto);
    }


}
