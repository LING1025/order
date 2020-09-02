package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.OrdersStepwise;
import com.funtl.myshop.plus.provider.domain.StepwiseList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersStepwiseMapper extends MyMapper<OrdersStepwise> {
    List<StepwiseList> selectByOrdersAuto(@Param("param") Long ordersAuto);
}
