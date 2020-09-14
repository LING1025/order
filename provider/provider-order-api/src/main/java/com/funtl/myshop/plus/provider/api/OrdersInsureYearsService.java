package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.InsuranceTableList;

import java.util.List;

public interface OrdersInsureYearsService{

    /**
     * 根据试算单号和年份获取保单明细
     * @param ordersAuto
     * @param insureYear
     * @return
     */
    List<InsuranceTableList> selectByOrdersAutoAndYear(Long ordersAuto,Integer insureYear);

}
