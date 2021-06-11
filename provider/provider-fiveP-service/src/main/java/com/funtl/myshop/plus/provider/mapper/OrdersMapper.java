package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.Orders;
import com.funtl.myshop.plus.provider.domain.PaymentList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersMapper extends MyMapper<Orders> {
    /*客户汇款输入：查询按钮*/
    List<PaymentList> selectPaymentList(@Param("param")  PaymentList paymentList);
}
