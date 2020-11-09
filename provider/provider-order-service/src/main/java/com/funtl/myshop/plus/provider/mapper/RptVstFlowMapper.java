package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.RptVstFlow;
import com.funtl.myshop.plus.provider.domain.TripDetailList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface RptVstFlowMapper extends MyMapper<RptVstFlow> {
    List<TripDetailList> selectByRptVstAuto(@Param("rptVstAuto") Long rptVstAuto);
}
