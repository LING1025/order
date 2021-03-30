package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.OutBound;
import com.funtl.myshop.plus.provider.mapper.OutBoundMapper;
import com.funtl.myshop.plus.provider.api.OutBoundService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class OutBoundServiceImpl implements OutBoundService{

    @Resource
    private OutBoundMapper outBoundMapper;


    @Override
    public Long insert(OutBound outBound) {
        Integer i = outBoundMapper.insertUseGeneratedKeys(outBound);
        return i == 1 ? outBound.getOutBoundAuto():0;
    }
}
