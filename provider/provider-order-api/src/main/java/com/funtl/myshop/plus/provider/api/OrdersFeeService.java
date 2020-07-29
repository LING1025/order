package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.FeeList;
import com.funtl.myshop.plus.provider.domain.OrdersFee;

import java.util.List;

public interface OrdersFeeService{
    /**
     * 根据试算单号获取上牌规费明细数据
     * @param ordersAuto
     * @return
     */
    List<FeeList> selectFeeList(Long ordersAuto);

}
