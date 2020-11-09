package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.RptVst;
import com.funtl.myshop.plus.provider.domain.TripRecorderList;
import com.funtl.myshop.plus.provider.dto.TripQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface RptVstMapper extends MyMapper<RptVst> {
    List<TripRecorderList> selectByTrip(@Param("param") TripQueryParam tripQueryParam);
}
