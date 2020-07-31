package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.ClasenList;
import com.funtl.myshop.plus.provider.domain.Order;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrderMapper extends MyMapper<Order> {
    List<ClasenList> selectClasenList(@Param("param") Long ordersAuto);
}
