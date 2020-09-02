package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.FeeList;
import com.funtl.myshop.plus.provider.domain.OrdersFee;
import com.funtl.myshop.plus.provider.mapper.OrdersFeeMapper;
import com.funtl.myshop.plus.provider.api.OrdersFeeService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class OrdersFeeServiceImpl implements OrdersFeeService{

    @Resource
    private OrdersFeeMapper ordersFeeMapper;


    @Override
    public List<FeeList> selectFeeList(Long ordersAuto) {
        return ordersFeeMapper.selectFeeList(ordersAuto);
    }

    @Override
    public List<FeeList> selectFeeBackList(Long ordersAuto) {
        return ordersFeeMapper.selectFeeBackList(ordersAuto);
    }
}
