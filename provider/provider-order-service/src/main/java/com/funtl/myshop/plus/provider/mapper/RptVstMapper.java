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

    CrmDetail selectByRptVstAuto(@Param("rptVstAuto") Long rptVstAuto,@Param("contName") String contName);

    List<CustomerNameSelect> selectByFName(@Param("fName") String fName,@Param("salesAuto") Long salesAuto);

    List<ContNameSelect> selectByTradeItemAuto(@Param("tradeItemAuto") Long tradeItemAuto,@Param("contName") String contName);

    List<CrmItemNameSelect> selectByTypes(@Param("types") Integer types,@Param("num") Integer num);

}
