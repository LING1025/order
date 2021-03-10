package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.PurchaseRRFlow;

public interface PurchaseRRFlowService{

    /**
     * 请款送签
     * @param purchaseRequestAuto
     * @param requestUser
     * @return
     */
    Integer flowInsert(Long purchaseRequestAuto,Long requestUser);

    /**
     * 修改
     * @param purchaseRRFlow
     * @return
     */
    Integer update(PurchaseRRFlow purchaseRRFlow);

    /**
     * 费用列表删除信息时也要将送签删除，因为请款一键送签了
     * @param rrAuto
     * @return
     */
    Integer deleteByRrAuto(Long rrAuto);
}
