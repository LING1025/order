package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.AccessoryList;
import com.funtl.myshop.plus.provider.domain.OrdersAccessary;
import com.funtl.myshop.plus.provider.mapper.OrdersAccessaryMapper;
import com.funtl.myshop.plus.provider.api.OrdersAccessaryService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class OrdersAccessaryServiceImpl implements OrdersAccessaryService{

    @Resource
    private OrdersAccessaryMapper ordersAccessaryMapper;


    @Override
    public List<AccessoryList> selectAccessoryList(Long ordersAuto) {
        return ordersAccessaryMapper.selectAccessoryList(ordersAuto);
    }
}
