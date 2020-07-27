package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.MasterList;
import com.funtl.myshop.plus.provider.domain.Orders;
import com.funtl.myshop.plus.provider.domain.OrdersList;

import java.util.List;

public interface OrdersService{

    /**
     * 根据角色id集合获取主档信息待签核信息
     * @param roleIds
     * @return
     */
    List<MasterList> selectByRoleIds(List<Long> roleIds);

    /**
     * 根据试算单号获取试算签核信息
     * @param ordersAuto
     * @return
     */
    OrdersList selectByOrdersAuto(Long ordersAuto);

}
