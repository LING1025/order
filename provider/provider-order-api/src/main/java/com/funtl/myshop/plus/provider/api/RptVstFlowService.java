package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.RptVstFlow;
import com.funtl.myshop.plus.provider.domain.TripDetailList;

import java.util.List;

public interface RptVstFlowService{
    /**
     * 根据行程单号获取审核信息
     * @param rptVstAuto
     * @return
     */
    List<TripDetailList> selectByRptVstAuto(Long rptVstAuto);

}
