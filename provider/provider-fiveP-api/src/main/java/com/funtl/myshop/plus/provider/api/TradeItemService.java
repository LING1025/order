package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CusBackground;
import com.funtl.myshop.plus.provider.domain.TradeItem;
public interface TradeItemService{

    /**
     * 根据客户序号获取客户背景数据
     * @param tradeItemAuto
     * @return
     */
    CusBackground selectByTradeItemAuto(Long tradeItemAuto);

}
