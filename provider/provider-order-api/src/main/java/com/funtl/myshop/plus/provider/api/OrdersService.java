package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.*;

import java.util.List;

public interface OrdersService{

    /**
     * 根据角色id、代理人id获取主档信息待签核信息
     * @param rolesAuto
     * @param userAuto
     * @return
     */
    List<MasterList> selectByRoleIds(Long rolesAuto,Long userAuto);

    /**
     * 根据角色id、代理人id获取可跨阶签核信息
     * @param rolesAuto
     * @param userAuto
     * @return
     */
    List<MasterList> selectCrossList(Long rolesAuto,Long userAuto);

    /**
     * 根据试算单号获取直租试算签核信息
     * @param ordersAuto
     * @return
     */
    OrdersList selectOrdersList(Long ordersAuto);

    /**
     * 根据试算单号获取报价车商历史成交记录
     * @param ordersAuto
     * @return
     */
    List<SupplierList> selectSupplierList(Long ordersAuto);

    /**
     * 根据试算单号获取回租试算签核信息
     * @param ordersAuto
     * @return
     */
    OrdersBackList selectOrdersBackList(Long ordersAuto);

    /**
     * 根据试算单号判断试算单号框外面显示的值
     * @param ordersAuto
     * @return
     */
    MsgDto selectMsg(Long ordersAuto);

}
