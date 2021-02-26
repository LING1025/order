package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Purchase;
public interface PurchaseService{
    /**
     * 插入用车请款物品明细
     * @param purchase
     * @return
     */
    Long insert(Purchase purchase);

}
