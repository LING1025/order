package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.BudgetList;
import com.funtl.myshop.plus.provider.domain.OrdersBudget;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersBudgetMapper extends MyMapper<OrdersBudget> {
    List<BudgetList> selectBudgetList(@Param("param") Long ordersAuto);
}
