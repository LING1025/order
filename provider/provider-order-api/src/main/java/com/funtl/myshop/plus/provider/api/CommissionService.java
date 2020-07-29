package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Commission;
import com.funtl.myshop.plus.provider.domain.CommissionList;

import java.util.List;

public interface CommissionService{
    /**
     * 根据试算单号获取佣金明细
     * @param ordersAuto
     * @return
     */
    List<CommissionList> selectCommissionList(Long ordersAuto);

}
