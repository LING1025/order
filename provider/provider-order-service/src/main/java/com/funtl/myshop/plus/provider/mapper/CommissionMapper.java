package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.Commission;
import com.funtl.myshop.plus.provider.domain.CommissionList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface CommissionMapper extends MyMapper<Commission> {
    List<CommissionList> selectCommissionList(@Param("param") Long ordersAuto);
}
