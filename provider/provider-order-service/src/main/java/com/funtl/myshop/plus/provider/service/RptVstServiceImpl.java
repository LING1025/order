package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.TripRecorderList;
import com.funtl.myshop.plus.provider.dto.TripQueryParam;
import com.funtl.myshop.plus.provider.mapper.RptVstMapper;
import com.funtl.myshop.plus.provider.domain.RptVst;
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
}
