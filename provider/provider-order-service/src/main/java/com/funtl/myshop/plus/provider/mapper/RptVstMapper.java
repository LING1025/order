package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.TripQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface RptVstMapper extends MyMapper<RptVst> {
    List<TripRecorderList> selectByTrip(@Param("param") TripQueryParam tripQueryParam);

    List<TripRecorderList> selectByTripTwo(@Param("param") TripQueryParam tripQueryParam);

    List<CrmTripList> selectCrmTripList(@Param("userAuto") Integer userAuto, @Param("customerName") String customerName);

    CrmDetail selectByRptVstAuto(@Param("rptVstAuto") Long rptVstAuto);

    List<CrmSelect> selectByTradeItemAuto(@Param("tradeItemAuto") Long tradeItemAuto, @Param("type") Integer type);

    List<CrmSelect> selectByTypes(@Param("types") Integer types);
}
