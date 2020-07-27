package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.MasterList;
import com.funtl.myshop.plus.provider.domain.Orders;
import com.funtl.myshop.plus.provider.domain.OrdersList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersMapper extends MyMapper<Orders> {
    List<MasterList> selectByRoleIds(@Param("roleIds") List<Long> roleIds);

    OrdersList selectByOrdersAuto(@Param("params") Long ordersAuto);
}
