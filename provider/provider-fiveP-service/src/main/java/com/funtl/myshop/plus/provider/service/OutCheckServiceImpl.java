package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.OutCheckMapper;
import com.funtl.myshop.plus.provider.domain.OutCheck;
import com.funtl.myshop.plus.provider.api.OutCheckService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class OutCheckServiceImpl implements OutCheckService{

    @Resource
    private OutCheckMapper outCheckMapper;


}
