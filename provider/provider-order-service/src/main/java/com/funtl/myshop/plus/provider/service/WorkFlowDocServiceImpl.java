package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.SignOffList;
import com.funtl.myshop.plus.provider.domain.WorkFlowDoc;
import com.funtl.myshop.plus.provider.dto.FlowAuditDto;
import com.funtl.myshop.plus.provider.dto.FlowCURDto;
import com.funtl.myshop.plus.provider.mapper.WorkFlowDocMapper;
import com.funtl.myshop.plus.provider.api.WorkFlowDocService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class WorkFlowDocServiceImpl implements WorkFlowDocService{

    @Resource
    private WorkFlowDocMapper workFlowDocMapper;

    @Override
    public List<WorkFlowDoc> selectWorkFlowDoc(Long docPostID, Integer roleId, Integer type) {
        return workFlowDocMapper.selectWorkFlowDoc(docPostID,roleId,type);
    }

    @Override
    public Integer insert(FlowAuditDto flowAuditDto) {
        return workFlowDocMapper.insertFlowAudit(flowAuditDto);
    }

    @Override
    public Integer insertFlowCUR(FlowCURDto flowCURDto) {
        return workFlowDocMapper.insertFlowCUR(flowCURDto);
    }
}
