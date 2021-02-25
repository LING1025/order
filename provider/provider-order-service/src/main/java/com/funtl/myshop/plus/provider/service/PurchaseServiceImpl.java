package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.Purchase;
import com.funtl.myshop.plus.provider.mapper.PurchaseMapper;
import com.funtl.myshop.plus.provider.api.PurchaseService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class PurchaseServiceImpl implements PurchaseService{

    @Resource
    private PurchaseMapper purchaseMapper;


}
