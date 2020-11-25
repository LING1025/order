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
    CrmDetail selectByRptVstAuto(Long rptVstAuto,String contName);

    /**
     * 编辑CRM行程报告具体数据
     * @param rptVst
     * @return
     */
    Integer update(RptVst rptVst);

    /**
     * 获取客户名称下拉选
     * @param fName
     * @return
     */
    List<CustomerNameSelect> selectByFName(String fName,Long salesAuto);

    /**
     * 获取联系人下拉选
     * @param tradeItemAuto
     * @return
     */
    List<ContNameSelect> selectByTradeItemAuto(Long tradeItemAuto,String contName);

    /**
     * 获取客户来源、活动内容、进度下拉选
     * @param types
     * @return
     */
    List<CrmItemNameSelect> selectByTypes(Integer types,Integer num);

    /**
     * 新增CRM行程报告
     * @param rptVst
     * @return
     */
    Long insert(RptVst rptVst);

    /**
     * 删除
     * @param rptVstAuto
     * @return
     */
    Integer deleteByRptVstId(Long rptVstAuto);
}
