package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.Commission;
import com.funtl.myshop.plus.provider.mapper.CommissionMapper;
import com.funtl.myshop.plus.provider.api.CommissionService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class CommissionServiceImpl implements CommissionService{

    @Resource
    private CommissionMapper commissionMapper;

}
