package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.SignOffList;
import com.funtl.myshop.plus.provider.domain.WorkFlowDoc;
import com.funtl.myshop.plus.provider.mapper.WorkFlowDocMapper;
import com.funtl.myshop.plus.provider.api.WorkFlowDocService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class WorkFlowDocServiceImpl implements WorkFlowDocService{

    @Resource
    private WorkFlowDocMapper workFlowDocMapper;

    @Override
    public Integer update(WorkFlowDoc workFlowDoc) {
        return workFlowDocMapper.updateByPrimaryKeySelective(workFlowDoc);
    }

    @Override
    public SignOffList selectByDocPostIDAndRoleId(Long docPostID, Integer roleId) {
        return workFlowDocMapper.selectSignOffList(docPostID,roleId);
    }

    @Override
    public Integer deleteById(Long workFlowDocAuto) {
        return workFlowDocMapper.deleteByPrimaryKey(workFlowDocAuto);
    }

    @Override
    public List<WorkFlowDoc> selectWorkFlowDoc(Long docPostID, Integer roleId, Integer type) {
        return workFlowDocMapper.selectWorkFlowDoc(docPostID,roleId,type);
    }
}
