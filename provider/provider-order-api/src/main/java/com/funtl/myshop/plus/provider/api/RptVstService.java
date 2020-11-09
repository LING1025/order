package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.RptVst;
import com.funtl.myshop.plus.provider.domain.TripRecorderList;
import com.funtl.myshop.plus.provider.dto.TripQueryParam;

import java.util.List;

public interface RptVstService{
    /**
     * 获取行程报告记录-主档信息待签核
     * @param tripQueryParam
     * @return
     */
    List<TripRecorderList> selectByTrip(TripQueryParam tripQueryParam);

    /**
     * 获取行程报告记录-可跨签信息
     * @param tripQueryParam
     * @return
     */
    List<TripRecorderList> selectByTripTwo(TripQueryParam tripQueryParam);
}
