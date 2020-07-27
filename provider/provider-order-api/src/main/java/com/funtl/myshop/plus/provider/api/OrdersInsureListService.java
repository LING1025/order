package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.InsuranceContentList;
import com.funtl.myshop.plus.provider.domain.OrdersInsureList;

import java.util.List;

public interface OrdersInsureListService{

    /**
     * 根据试算单号获取保险内容
     * @param ordersAuto
     * @return
     */
    List<InsuranceContentList> selectInsuranceContentList(Long ordersAuto);

}
