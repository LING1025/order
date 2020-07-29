package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AccessoryList;
import com.funtl.myshop.plus.provider.domain.OrdersAccessary;

import java.util.List;

public interface OrdersAccessaryService{

    /**
     * 根据试算单号获取配件明细数据
     * @param ordersAuto
     * @return
     */
    List<AccessoryList> selectAccessoryList(Long ordersAuto);
}
