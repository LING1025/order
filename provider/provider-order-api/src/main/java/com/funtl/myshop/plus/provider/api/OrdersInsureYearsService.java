package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.InsuranceList;
import com.funtl.myshop.plus.provider.domain.OrdersInsureYears;
public interface OrdersInsureYearsService{

    /**
     * 根据试算单号获取保险明细上部分信息
     * @param ordersAuto
     * @return
     */
    InsuranceList selectInsuranceList(Long ordersAuto);

}
