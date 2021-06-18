package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.IncomeList;
import com.funtl.myshop.plus.provider.domain.Orders;
import com.funtl.myshop.plus.provider.domain.PaymentFileList;
import com.funtl.myshop.plus.provider.domain.PaymentList;
import com.funtl.myshop.plus.provider.dto.IncomeInsertDto;
import com.funtl.myshop.plus.provider.dto.PaymentQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersMapper extends MyMapper<Orders> {
    /*客户汇款输入：查询按钮*/
    List<PaymentList> selectPaymentList(@Param("param") PaymentQueryParam paymentQueryParam);

    /*客户汇款输入：客户汇款记录*/
    List<IncomeList> selectIncomeList(@Param("type") Integer type, @Param("searchWord") String searchWord);

    /*客户汇款输入：附件列表*/
    List<PaymentFileList> selectPaymentFileList(@Param("type") Integer type, @Param("docPostId") Long docPostId);

    /*客户汇款输入：新增汇款*/
    Integer createIncome(@Param("param") IncomeInsertDto incomeInsertDto);

    /*客户汇款输入：新增汇款判断汇款类别是否重复*/
    Integer selectType(@Param("type") Integer type, @Param("creditMainAuto") Long creditMainAuto);

    /*客户汇款输入：删除汇款*/
    Integer deleteIncome(@Param("loginUserId") Long loginUserId, @Param("bookCarIncomeAuto") Long bookCarIncomeAuto);

    /*客户汇款输入：删除附件明细*/
    Integer deleteFile(@Param("loginUserId") Long loginUserId, @Param("fileUploadAuto") Long fileUploadAuto);
}
