package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.BudgetList;
import com.funtl.myshop.plus.provider.domain.OrdersBudget;
import com.funtl.myshop.plus.provider.mapper.OrdersBudgetMapper;
import com.funtl.myshop.plus.provider.api.OrdersBudgetService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class OrdersBudgetServiceImpl implements OrdersBudgetService{

    @Resource
    private OrdersBudgetMapper ordersBudgetMapper;


    @Override
    public List<BudgetList> selectBudgetList(Long ordersAuto) {
        return ordersBudgetMapper.selectBudgetList(ordersAuto);
    }
}
