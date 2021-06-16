package com.funtl.myshop.plus.provider.api;
import com.funtl.myshop.plus.provider.domain.IncomeList;
import com.funtl.myshop.plus.provider.domain.PaymentFileList;
import com.funtl.myshop.plus.provider.domain.PaymentList;
import com.funtl.myshop.plus.provider.dto.PaymentQueryParam;

import java.util.List;

public interface OrdersService{
    /**
     * 客户汇款输入：查询按钮
     */
    List<PaymentList> selectPaymentList(PaymentQueryParam paymentQueryParam);

    /**
     * 客户汇款输入：客户汇款记录
     * @param type
     * @param searchWord
     * @return
     */
    List<IncomeList> selectIncomeList(Integer type,String searchWord);

    /**
     * 客户汇款输入：附件列表
     * @param type
     * @param docPostId
     * @return
     */
    List<PaymentFileList> selectPaymentFileList(Integer type,Long docPostId);
}
