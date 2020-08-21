package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.WxEncryptedData;
public interface WxEncryptedDataService{

    /**
     * 获取用户信息
     * @param openId
     * @return
     */
    WxEncryptedData getOpenId(String openId);

}
