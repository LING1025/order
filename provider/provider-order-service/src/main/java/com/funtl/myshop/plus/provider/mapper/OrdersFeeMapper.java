package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.FeeList;
import com.funtl.myshop.plus.provider.domain.OrdersFee;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersFeeMapper extends MyMapper<OrdersFee> {
    List<FeeList> selectFeeList(@Param("param") Long ordersAuto);

    List<FeeList> selectFeeBackList(@Param("param") Long ordersAuto);
}
