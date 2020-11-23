package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ClasenList;

import java.util.List;

public interface OrderService{

    /**
     * 根据试算单号获取报价车型历史成交记录
     * @param ordersAuto
     * @return
     */
    List<ClasenList> selectClasenList(Long ordersAuto);


}
