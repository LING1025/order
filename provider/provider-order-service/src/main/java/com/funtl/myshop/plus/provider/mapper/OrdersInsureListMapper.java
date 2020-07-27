package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.InsuranceContentList;
import com.funtl.myshop.plus.provider.domain.OrdersInsureList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersInsureListMapper extends MyMapper<OrdersInsureList> {
    List<InsuranceContentList> selectInsuranceContentList(@Param("param") Long ordersAuto);
}
