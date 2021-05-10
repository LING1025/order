package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.LKRQueryParam;
import com.funtl.myshop.plus.provider.dto.OpenQueryParam;

import java.util.List;

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

    /**
     * 删除用车请款数据
     * @param purchaseRequestAuto
     * @return
     */
    Integer deleteById(Long purchaseRequestAuto);

    /**
     * 车辆归还：费用列表数据
     * @param requestUser
     * @param carApplicationAuto
     * @return
     */
    List<PurchaseFeeList> selectPurchaseFeeList(Long requestUser, Long carApplicationAuto);

    /**
     * 修改
     * @param purchaseRequest
     * @return
     */
    Integer update(PurchaseRequest purchaseRequest);

    /**
     * 根据主键查询
     * @param purchaseRequestAuto
     * @return
     */
    PurchaseRequest selectById(Long purchaseRequestAuto);

    /**
     * 获取银行别下拉选数据
     * @param bankNameT
     * @return
     */
    List<BankList> selectBank(String bankNameT);

    /**
     * 领款人或供应商搜索
     * @param lkrQueryParam
     * @return
     */
    List<LKRList> selectLKR(LKRQueryParam lkrQueryParam);

    /**
     * 开户行搜索
     * @param openQueryParam
     * @return
     */
    List<OpenList> selectOpen(OpenQueryParam openQueryParam);
}
