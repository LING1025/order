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
    public List<MasterList> selectByRoleIds(Long rolesAuto, Long userAuto) {
        return ordersMapper.selectByRoleIds(rolesAuto,userAuto);
    }

    @Override
    public List<MasterList> selectCrossList(Long rolesAuto, Long userAuto) {
        return ordersMapper.selectCrossList(rolesAuto,userAuto);
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

    @Override
    public MsgDto selectMsg(Long ordersAuto) {
        return ordersMapper.selectMsg(ordersAuto);
    }

}
