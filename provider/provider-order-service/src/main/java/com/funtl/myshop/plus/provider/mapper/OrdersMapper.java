package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.*;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersMapper extends MyMapper<Orders> {
    List<MasterList> selectByRoleIds(@Param("roleIds") List<Long> roleIds);

    OrdersList selectByOrdersAuto(@Param("params") Long ordersAuto);

    List<SupplierList> selectSupplierList(@Param("params") Long ordersAuto);

    OrdersBackList selectOrdersBackList(@Param("params") Long ordersAuto);

    MsgDto selectMsg(@Param("params") Long ordersAuto);
}
