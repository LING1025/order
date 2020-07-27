package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.InsuranceContentList;
import com.funtl.myshop.plus.provider.mapper.OrdersInsureListMapper;
import com.funtl.myshop.plus.provider.domain.OrdersInsureList;
import com.funtl.myshop.plus.provider.api.OrdersInsureListService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class OrdersInsureListServiceImpl implements OrdersInsureListService{

    @Resource
    private OrdersInsureListMapper ordersInsureListMapper;

    @Override
    public List<InsuranceContentList> selectInsuranceContentList(Long ordersAuto) {
        return ordersInsureListMapper.selectInsuranceContentList(ordersAuto);
    }
}
