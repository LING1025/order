package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.OrderMapper;
import com.funtl.myshop.plus.provider.domain.Order;
import com.funtl.myshop.plus.provider.api.OrderService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class OrderServiceImpl implements OrderService{

    @Resource
    private OrderMapper orderMapper;

}
