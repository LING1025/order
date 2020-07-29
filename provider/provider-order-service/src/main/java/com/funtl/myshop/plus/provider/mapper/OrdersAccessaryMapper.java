package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.AccessoryList;
import com.funtl.myshop.plus.provider.domain.OrdersAccessary;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersAccessaryMapper extends MyMapper<OrdersAccessary> {
    List<AccessoryList> selectAccessoryList(@Param("param") Long ordersAuto);
}
