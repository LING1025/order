package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.SaleOpenIdList;
import com.funtl.myshop.plus.provider.domain.WxEncryptedData;

import java.util.List;

public interface WxEncryptedDataService{

    /**
     * 获取用户信息
     * @param openId
     * @return
     */
    WxEncryptedData getOpenId(String openId);

    /**
     * 小程序已授权用户数据
     * @return
     */
    List<SaleOpenIdList> selectSaleOpenId(Long salesAuto);

}
