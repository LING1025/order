package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.OrderBudgetMapper;
import com.funtl.myshop.plus.provider.domain.OrderBudget;
import com.funtl.myshop.plus.provider.api.OrderBudgetService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class OrderBudgetServiceImpl implements OrderBudgetService{

    @Resource
    private OrderBudgetMapper orderBudgetMapper;

}
