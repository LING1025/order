package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.InsuranceList;
import com.funtl.myshop.plus.provider.domain.OrdersInsureYears;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

public interface OrdersInsureYearsMapper extends MyMapper<OrdersInsureYears> {
    InsuranceList selectInsuranceList(@Param("param") Long ordersAuto);
}
