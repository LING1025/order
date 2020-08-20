package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.WxEncryptedDataMapper;
import com.funtl.myshop.plus.provider.domain.WxEncryptedData;
import com.funtl.myshop.plus.provider.api.WxEncryptedDataService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class WxEncryptedDataServiceImpl implements WxEncryptedDataService{

    @Resource
    private WxEncryptedDataMapper wxEncryptedDataMapper;

}
