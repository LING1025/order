package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.PurchaseService;
import com.funtl.myshop.plus.provider.domain.Purchase;
import com.funtl.myshop.plus.provider.mapper.PurchaseMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

@Service(version = "1.0.0")
public class PurchaseServiceImpl implements PurchaseService{

    @Resource
    private PurchaseMapper purchaseMapper;


    @Override
    public Long insert(Purchase purchase) {
        Integer i = purchaseMapper.insertUseGeneratedKeys(purchase);
        return i == 1 ? purchase.getPurchaseAuto() : 0;
    }

    @Override
    public Integer deleteById(Long purchaseAuto) {
        return purchaseMapper.deleteByPrimaryKey(purchaseAuto);
    }
}
