package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.PurchaseRRFlowMapper;
import com.funtl.myshop.plus.provider.domain.PurchaseRRFlow;
import com.funtl.myshop.plus.provider.api.PurchaseRRFlowService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class PurchaseRRFlowServiceImpl implements PurchaseRRFlowService{

    @Resource
    private PurchaseRRFlowMapper purchaseRRFlowMapper;

}
