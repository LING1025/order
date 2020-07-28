package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.SignOffList;
import com.funtl.myshop.plus.provider.mapper.OrdersFDetailMapper;
import com.funtl.myshop.plus.provider.api.OrdersFDetailService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class OrdersFDetailServiceImpl implements OrdersFDetailService{

    @Resource
    private OrdersFDetailMapper ordersFDetailMapper;

    @Override
    public List<SignOffList> selectSignOffList(Long ordersAuto) {
        return ordersFDetailMapper.selectSignOffList(ordersAuto);
    }
}
