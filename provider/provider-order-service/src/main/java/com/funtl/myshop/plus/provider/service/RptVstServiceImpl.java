package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.RptVstMapper;
import com.funtl.myshop.plus.provider.domain.RptVst;
import com.funtl.myshop.plus.provider.api.RptVstService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class RptVstServiceImpl implements RptVstService{

    @Resource
    private RptVstMapper rptVstMapper;

}
