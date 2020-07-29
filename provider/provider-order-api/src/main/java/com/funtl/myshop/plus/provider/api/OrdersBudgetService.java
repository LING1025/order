package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.BudgetList;
import com.funtl.myshop.plus.provider.domain.OrdersBudget;

import java.util.List;

public interface OrdersBudgetService{
    /**
     * 根据试算单号获取其他费用明细数据
     * @param ordersAuto
     * @return
     */
    List<BudgetList> selectBudgetList(Long ordersAuto);


}
