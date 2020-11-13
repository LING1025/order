package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.AddressList;
import com.funtl.myshop.plus.provider.domain.VisitPlan;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface VisitPlanMapper extends MyMapper<VisitPlan> {
    List<AddressList> selectByType(@Param("type") Integer type,@Param("code") Long code);
}
