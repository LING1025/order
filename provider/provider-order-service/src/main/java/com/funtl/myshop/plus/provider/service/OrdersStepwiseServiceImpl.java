package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.OrdersStepwise;
import com.funtl.myshop.plus.provider.mapper.OrdersStepwiseMapper;
import com.funtl.myshop.plus.provider.api.OrdersStepwiseService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class OrdersStepwiseServiceImpl implements OrdersStepwiseService{

    @Resource
    private OrdersStepwiseMapper ordersStepwiseMapper;

}
