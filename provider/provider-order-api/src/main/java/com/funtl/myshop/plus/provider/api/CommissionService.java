package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CommissionList;
import com.funtl.myshop.plus.provider.domain.CommissionRecordList;

import java.util.List;

public interface CommissionService{
    /**
     * 根据试算单号获取佣金明细
     * @param ordersAuto
     * @return
     */
    List<CommissionList> selectCommissionList(Long ordersAuto);

    /**
     * 根据试算单号集合获取异常佣金人佣金记录
     * @param ordersAuto
     * @return
     */
    List<CommissionRecordList> selectRecord(List<Long> ordersAuto);
}
