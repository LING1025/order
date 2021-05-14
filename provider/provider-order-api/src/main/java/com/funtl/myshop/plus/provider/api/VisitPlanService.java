package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AddressList;
import com.funtl.myshop.plus.provider.domain.CrmArrangeList;
import com.funtl.myshop.plus.provider.domain.VisitPlan;
import com.funtl.myshop.plus.provider.dto.CrmArrangeDto;
import com.funtl.myshop.plus.provider.dto.CrmArrangeQueryParam;
import com.github.pagehelper.PageInfo;

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
    Long insert(VisitPlan visitPlan);

    /**
     * CRM:编辑行程安排
     * @param visitPlan
     * @return
     */
    Integer update(VisitPlan visitPlan);

    /**
     * VisitPlan表获取VisitAuto最大值
     * @return
     */
    VisitPlan selectMaxVisitAuto();

    /**
     * CRM:获取行程安排数据
     * @param crmArrangeQueryParam
     * @return
     */
    List<CrmArrangeList> selectCrmArrangeDto(CrmArrangeQueryParam crmArrangeQueryParam);

    /**
     * 判断拜访信息是否存在
     * @param visitId
     * @return
     */
    VisitPlan selectByVisitIdAndAuto(Long visitId,Integer visitAuto);

    /**
     * 通过拜访id获取拜访信息(不包括删除状态的)
     * @param visitId
     * @return
     */
    VisitPlan selectByVisitId(Long visitId);


}
