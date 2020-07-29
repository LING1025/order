package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.OrdersBudget;
import com.funtl.myshop.plus.provider.mapper.OrdersBudgetMapper;
import com.funtl.myshop.plus.provider.api.OrdersBudgetService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class OrdersBudgetServiceImpl implements OrdersBudgetService{

    @Resource
    private OrdersBudgetMapper ordersBudgetMapper;


}
