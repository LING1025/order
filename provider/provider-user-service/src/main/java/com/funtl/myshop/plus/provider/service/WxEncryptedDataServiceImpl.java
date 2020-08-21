package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.WxEncryptedDataMapper;
import com.funtl.myshop.plus.provider.domain.WxEncryptedData;
import com.funtl.myshop.plus.provider.api.WxEncryptedDataService;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

@Service(version = "1.0.0")
public class WxEncryptedDataServiceImpl implements WxEncryptedDataService{

    @Resource
    private WxEncryptedDataMapper wxEncryptedDataMapper;

    @Override
    public WxEncryptedData getOpenId(String openId) {
        Example example = new Example(WxEncryptedData.class);
        example.createCriteria().andEqualTo("openId",openId);
        return wxEncryptedDataMapper.selectOneByExample(example);
    }
}
