package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.MasterList;
import com.funtl.myshop.plus.provider.domain.OrdersList;
import com.funtl.myshop.plus.provider.domain.SupplierList;
import com.funtl.myshop.plus.provider.mapper.OrdersMapper;
import com.funtl.myshop.plus.provider.domain.Orders;
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

}
