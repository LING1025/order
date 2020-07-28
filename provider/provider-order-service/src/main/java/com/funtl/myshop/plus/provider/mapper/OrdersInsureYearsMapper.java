package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.InsuranceList;
import com.funtl.myshop.plus.provider.domain.InsuranceTableList;
import com.funtl.myshop.plus.provider.domain.OrdersInsureYears;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersInsureYearsMapper extends MyMapper<OrdersInsureYears> {
    InsuranceList selectInsuranceList(@Param("param") Long ordersAuto);

    List<InsuranceTableList> selectByOrdersAutoAndYear(@Param("ordersAuto") Long ordersAuto, @Param("insureYear") Integer insureYear);
}
