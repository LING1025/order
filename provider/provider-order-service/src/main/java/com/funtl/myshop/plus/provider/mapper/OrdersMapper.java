package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.LeasebackQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersMapper extends MyMapper<Orders> {
    List<MasterList> selectByRoleIds(@Param("rolesAuto") Long rolesAuto,@Param("userAuto") Long userAuto);

    OrdersList selectOrdersList(@Param("params") Long ordersAuto);

    List<SupplierList> selectSupplierList(@Param("params") Long ordersAuto);

    OrdersBackList selectOrdersBackList(@Param("params") Long ordersAuto);

    MsgDto selectMsg(@Param("params") Long ordersAuto);

    List<MasterList> selectCrossList(@Param("rolesAuto") Long rolesAuto,@Param("userAuto") Long userAuto);

    List<LeasebackList> selectLeasebackList(@Param("params") LeasebackQueryParam leasebackQueryParam);

    Leasebacks selectLeasebacks(@Param("ordersAuto") Long ordersAuto);
}
