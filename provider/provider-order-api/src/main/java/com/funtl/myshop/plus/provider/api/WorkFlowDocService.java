package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.WorkFlowDoc;
import com.funtl.myshop.plus.provider.dto.FlowAuditDto;
import com.funtl.myshop.plus.provider.dto.FlowCURDto;

import java.util.List;

public interface WorkFlowDocService{


    /**
     * 试算签核验证
     * @param docPostID
     * @param roleId
     * @param type
     * @return
     */
    List<WorkFlowDoc> selectWorkFlowDoc(Long docPostID,Integer roleId,Integer type);

    /**
     * 签核、核准
     * @param flowAuditDto
     * @return
     */
    Integer insert(FlowAuditDto flowAuditDto);

    /**
     * 驳回、作废
     * @param flowCURDto
     * @return
     */
    Integer insertFlowCUR(FlowCURDto flowCURDto);
}
