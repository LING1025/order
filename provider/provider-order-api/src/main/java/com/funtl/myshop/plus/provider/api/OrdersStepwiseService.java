package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.OrdersStepwise;
import com.funtl.myshop.plus.provider.domain.StepwiseList;

import java.util.List;

public interface OrdersStepwiseService{

    /**
     * 根据试算单号获取付款条件信息
     * @param ordersAuto
     * @return
     */
    List<StepwiseList> selectByOrdersAuto(Long ordersAuto);

}
