package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.SignOffList;
import com.funtl.myshop.plus.provider.domain.WorkFlowDoc;
import com.funtl.myshop.plus.provider.dto.FlowAuditDto;
import com.funtl.myshop.plus.provider.dto.FlowCURDto;

import java.util.List;

public interface WorkFlowDocService{

    /**
     * 修改签核信息
     * @param workFlowDoc
     * @return
     */
    Integer update(WorkFlowDoc workFlowDoc);

    /**
     * 根据试算单号和角色id获取未审核信息
     * @param docPostID
     * @param roleId
     * @return
     */
    SignOffList selectByDocPostIDAndRoleId(Integer docPostID,Integer roleId);

    Integer deleteById(Long workFlowDocAuto);

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
