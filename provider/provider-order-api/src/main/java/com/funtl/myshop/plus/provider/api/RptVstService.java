package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CrmDetail;
import com.funtl.myshop.plus.provider.domain.CrmTripList;
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

    /**
     * 根据用户序号、客户名称获取CRM行程报告列表数据
     * @param userAuto
     * @param customerName
     * @return
     */
    List<CrmTripList> selectCrmTripList(Integer userAuto,String customerName);

    /**
     * 根据拜访序号获取CRM行程报告具体数据
     * @param visitAuto
     * @return
     */
    CrmDetail selectByVisitAuto(Integer visitAuto);

    /**
     * 编辑CRM行程报告具体数据
     * @param rptVst
     * @return
     */
    Integer updateByVisitAuto(RptVst rptVst);
}
