package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AddressList;
import com.funtl.myshop.plus.provider.domain.VisitPlan;

import java.util.List;

public interface VisitPlanService{

    /**
     * 获取省、市、区名称
     * @param type
     * @return
     */
    List<AddressList> selectByType (Integer type,Long code);

    /**
     * CRM:新增行程安排
     * @param visitPlan
     * @return
     */
    Integer insert(VisitPlan visitPlan);

    /**
     * VisitPlan表获取VisitAuto最大值
     * @return
     */
    VisitPlan selectMaxVisitAuto();
}
