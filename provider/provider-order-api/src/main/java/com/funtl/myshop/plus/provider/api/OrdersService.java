package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.MasterList;
import com.funtl.myshop.plus.provider.domain.Orders;

import java.util.List;

public interface OrdersService{

    /**
     * 根据角色id集合获取主档信息待签核信息
     * @param roleIds
     * @return
     */
    List<MasterList> selectByRoleIds(List<Long> roleIds);

}
