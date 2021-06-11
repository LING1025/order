package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Orders;
import com.funtl.myshop.plus.provider.domain.PaymentList;

import java.util.List;

public interface OrdersService{
    /**
     * 客户汇款输入：查询按钮
     */
    List<PaymentList> selectPaymentList(PaymentList paymentList);

}
