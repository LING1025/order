package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.*;
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

    /**
     * 根据用户序号、客户名称获取CRM行程报告列表数据
     * @param userAuto
     * @param customerName
     * @return
     */
    List<CrmTripList> selectCrmTripList(Integer userAuto,String customerName);

    /**
     * 根据报告序号获取CRM行程报告具体数据
     * @param rptVstAuto
     * @return
     */
    CrmDetail selectByRptVstAuto(Long rptVstAuto);

    /**
     * 编辑CRM行程报告具体数据
     * @param rptVst
     * @return
     */
    Integer update(RptVst rptVst);

    /**
     * 根据对象序号获取客户名称、联系人下拉选
     * @param tradeItemAuto
     * @return
     */
    List<CrmSelect> selectByTradeItemAuto(Long tradeItemAuto, Integer type);

    /**
     * 获取客户来源、活动内容、进度下拉选
     * @param types
     * @return
     */
    List<CrmItemNameSelect> selectByTypes(Integer types);
}
