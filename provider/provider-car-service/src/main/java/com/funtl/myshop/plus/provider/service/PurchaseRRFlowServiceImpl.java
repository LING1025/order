package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.PurchaseRRFlowService;
import com.funtl.myshop.plus.provider.domain.PurchaseRRFlow;
import com.funtl.myshop.plus.provider.mapper.PurchaseRRFlowMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class PurchaseRRFlowServiceImpl implements PurchaseRRFlowService{

    @Resource
    private PurchaseRRFlowMapper purchaseRRFlowMapper;

    @Override
    public Integer flowInsert(Long purchaseRequestAuto, Long requestUser) {
        return purchaseRRFlowMapper.flowInsert(purchaseRequestAuto,requestUser);
    }

    @Override
    public Integer update(PurchaseRRFlow purchaseRRFlow) {
        return purchaseRRFlowMapper.updateByPrimaryKeySelective(purchaseRRFlow);
    }

    @Override
    public Integer deleteByRrAuto(Long rrAuto) {
        return purchaseRRFlowMapper.deleteByRrAuto(rrAuto);
    }
}
