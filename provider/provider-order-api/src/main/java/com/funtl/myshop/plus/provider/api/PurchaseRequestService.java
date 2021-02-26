package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.PurchaseRequest;
import com.funtl.myshop.plus.provider.domain.RequestInc;

public interface PurchaseRequestService{

    /**
     * 根据用车请款人获取公司别、使用部门
     * @param userAuto
     * @return
     */
    RequestInc selectInc(Long userAuto);

    /**
     * 插入用车请款数据
     * @param purchaseRequest
     * @return
     */
    Long insert(PurchaseRequest purchaseRequest);
}
