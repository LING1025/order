package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.BankNameQueryParam;
import com.funtl.myshop.plus.provider.dto.IncomeInsertDto;
import com.funtl.myshop.plus.provider.dto.PaymentQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrdersMapper extends MyMapper<Orders> {
    /*客户汇款输入：查询按钮*/
    List<PaymentList> selectPaymentList(@Param("param") PaymentQueryParam paymentQueryParam);

    /*客户汇款输入\拨款申请作业：客户汇款记录*/
    List<IncomeList> selectIncomeList(@Param("type") Integer type, @Param("searchWord") String searchWord);

    /*客户汇款输入\拨款申请作业：附件列表*/
    List<PaymentFileList> selectPaymentFileList(@Param("type") Integer type, @Param("docPostId") Long docPostId);

    /*客户汇款输入：新增汇款*/
    Integer createIncome(@Param("param") IncomeInsertDto incomeInsertDto);

    /*客户汇款输入：新增汇款判断汇款类别是否重复*/
    Integer selectType(@Param("type") Integer type, @Param("creditMainAuto") Long creditMainAuto);

    /*客户汇款输入：删除汇款*/
    Integer deleteIncome(@Param("loginUserId") Long loginUserId, @Param("bookCarIncomeAuto") Long bookCarIncomeAuto);

    /*客户汇款输入\拨款申请作业：删除附件明细*/
    Integer deleteFile(@Param("loginUserId") Long loginUserId, @Param("fileUploadAuto") Long fileUploadAuto);

    /*拨款申请作业：查询按钮*/
    List<GrantList> selectGrantList(@Param("param") PaymentQueryParam paymentQueryParam);

    /*拨款申请作业：车款暂借明细*/
    List<CarZjList> selectCarZjList(@Param("creditMainAuto") Long creditMainAuto, @Param("isAppropriation") Integer isAppropriation);

    /*拨款申请作业：开户行列表*/
    List<BankNameList> selectBankNames(@Param("param") BankNameQueryParam bankNameQueryParam);
}
