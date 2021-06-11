package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.OrdersMapper;
import com.funtl.myshop.plus.provider.domain.Orders;
import com.funtl.myshop.plus.provider.api.OrdersService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class OrdersServiceImpl implements OrdersService{

    @Resource
    private OrdersMapper ordersMapper;

}
