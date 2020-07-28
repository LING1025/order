package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.OrdersFDetail;
import com.funtl.myshop.plus.provider.domain.SignOffList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersFDetailMapper extends MyMapper<OrdersFDetail> {
    List<SignOffList> selectSignOffList(@Param("param") Long ordersAuto);
}
