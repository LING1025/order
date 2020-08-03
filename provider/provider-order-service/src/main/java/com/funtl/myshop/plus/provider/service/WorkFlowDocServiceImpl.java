package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.WorkFlowDoc;
import com.funtl.myshop.plus.provider.mapper.WorkFlowDocMapper;
import com.funtl.myshop.plus.provider.api.WorkFlowDocService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class WorkFlowDocServiceImpl implements WorkFlowDocService{

    @Resource
    private WorkFlowDocMapper workFlowDocMapper;

}
