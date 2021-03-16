package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.PurchaseRequestService;
import com.funtl.myshop.plus.provider.domain.PurchaseFeeList;
import com.funtl.myshop.plus.provider.domain.PurchaseRequest;
import com.funtl.myshop.plus.provider.domain.RequestInc;
import com.funtl.myshop.plus.provider.mapper.PurchaseRequestMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(version = "1.0.0")
public class PurchaseRequestServiceImpl implements PurchaseRequestService{

    @Resource
    private PurchaseRequestMapper purchaseRequestMapper;

    @Override
    public RequestInc selectInc(Long userAuto) {
        return purchaseRequestMapper.selectInc(userAuto);
    }

    @Override
    public Long insert(PurchaseRequest purchaseRequest) {
        Integer i = purchaseRequestMapper.insertUseGeneratedKeys(purchaseRequest);
        return i == 1 ? purchaseRequest.getPurchaseRequestAuto() : 0;
    }

    @Override
    public Integer deleteById(Long purchaseRequestAuto) {
        return purchaseRequestMapper.deleteByPrimaryKey(purchaseRequestAuto);
    }

    @Override
    public List<PurchaseFeeList> selectPurchaseFeeList(Long requestUser, Long carApplicationAuto) {
        return purchaseRequestMapper.selectPurchaseFeeList(requestUser,carApplicationAuto);
    }

    @Override
    public Integer update(PurchaseRequest purchaseRequest) {
        return purchaseRequestMapper.updateByPrimaryKeySelective(purchaseRequest);
    }

    @Override
    public PurchaseRequest selectById(Long purchaseRequestAuto) {
        return purchaseRequestMapper.selectByPrimaryKey(purchaseRequestAuto);
    }



}
