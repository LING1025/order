package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.OrdersFDetail;
import com.funtl.myshop.plus.provider.domain.SignOffList;

import java.util.List;

public interface OrdersFDetailService{

    /**
     * 根据试算单号获取签核明细数据
     * @param ordersAuto
     * @return
     */
    List<SignOffList> selectSignOffList(Long ordersAuto);

    /**
     * 新增签核信息
     * @param ordersFDetail
     * @return
     */
    Integer insert(OrdersFDetail ordersFDetail);

}
