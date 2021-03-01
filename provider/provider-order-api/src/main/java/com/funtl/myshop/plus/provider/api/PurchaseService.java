package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Purchase;
public interface PurchaseService{
    /**
     * 插入用车请款物品明细
     * @param purchase
     * @return
     */
    Long insert(Purchase purchase);

    /**
     * 删除用车请款物品明细数据
     * @param purchaseAuto
     * @return
     */
    Integer deleteById(Long purchaseAuto);

}
