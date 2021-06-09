package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.FNamesQueryParam;
import com.funtl.myshop.plus.provider.dto.LeasebackQueryParam;
import com.funtl.myshop.plus.provider.dto.SupplierQueryParam;
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

    List<SupplierNames> selectSupplierNames(@Param("params") SupplierQueryParam supplierQueryParam);

    List<FNames> selectFNamesDto(@Param("params") FNamesQueryParam fNamesQueryParam);

    /*付款日修改审核：获取需审核列表数据*/
    List<OrdersPayList> selectOrdersPayList(Long userAuto);
}
