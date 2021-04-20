package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.TBoxLog;
import com.funtl.myshop.plus.provider.mapper.TBoxLogMapper;
import com.funtl.myshop.plus.provider.service.TBoxLogService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class TBoxLogServiceImpl implements TBoxLogService{

    @Resource
    private TBoxLogMapper tBoxLogMapper;

    @Override
    public Integer insertList(List<TBoxLog> tBoxLogList) {
        return tBoxLogMapper.insertList(tBoxLogList);
    }
}
