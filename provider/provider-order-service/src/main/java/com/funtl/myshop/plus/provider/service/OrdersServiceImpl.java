package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.mapper.OrdersMapper;
import com.funtl.myshop.plus.provider.api.OrdersService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class OrdersServiceImpl implements OrdersService{

    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<MasterList> selectByRoleIds(List<Long> roleIds) {
        return ordersMapper.selectByRoleIds(roleIds);
    }

    @Override
    public OrdersList selectByOrdersAuto(Long ordersAuto) {
        return ordersMapper.selectByOrdersAuto(ordersAuto);
    }

    @Override
    public List<SupplierList> selectSupplierList(Long ordersAuto) {
        return ordersMapper.selectSupplierList(ordersAuto);
    }

    @Override
    public OrdersBackList selectOrdersBackList(Long ordersAuto) {
        return ordersMapper.selectOrdersBackList(ordersAuto);
    }

}
