package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.InsuranceList;
import com.funtl.myshop.plus.provider.domain.InsuranceTableList;
import com.funtl.myshop.plus.provider.mapper.OrdersInsureYearsMapper;
import com.funtl.myshop.plus.provider.domain.OrdersInsureYears;
import com.funtl.myshop.plus.provider.api.OrdersInsureYearsService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class OrdersInsureYearsServiceImpl implements OrdersInsureYearsService{

    @Resource
    private OrdersInsureYearsMapper ordersInsureYearsMapper;


    @Override
    public InsuranceList selectInsuranceList(Long ordersAuto) {
        return ordersInsureYearsMapper.selectInsuranceList(ordersAuto);
    }

    @Override
    public List<InsuranceTableList> selectByOrdersAutoAndYear(Long ordersAuto, Integer insureYear) {
        return ordersInsureYearsMapper.selectByOrdersAutoAndYear(ordersAuto,insureYear);
    }
}
