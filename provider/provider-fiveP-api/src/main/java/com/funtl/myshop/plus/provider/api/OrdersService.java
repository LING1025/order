package com.funtl.myshop.plus.provider.api;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.BankNameQueryParam;
import com.funtl.myshop.plus.provider.dto.IncomeInsertDto;
import com.funtl.myshop.plus.provider.dto.PaymentQueryParam;

import java.util.List;

public interface OrdersService{
    /**
     * 客户汇款输入：查询按钮
     */
    List<PaymentList> selectPaymentList(PaymentQueryParam paymentQueryParam);

    /**
     * 客户汇款输入\拨款申请作业：客户汇款记录
     * @param type
     * @param searchWord
     * @return
     */
    List<IncomeList> selectIncomeList(Integer type,String searchWord);

    /**
     * 客户汇款输入\拨款申请作业：附件列表
     * @param type
     * @param docPostId
     * @return
     */
    List<PaymentFileList> selectPaymentFileList(Integer type,Long docPostId);

    /**
     * 客户汇款输入：新增、修改汇款
     * @param incomeInsertDto
     * @return
     */
    Integer createIncome(IncomeInsertDto incomeInsertDto);

    /**
     * 客户汇款输入：新增汇款判断汇款类别是否重复
     * @param type
     * @param creditMainAuto
     * @return
     */
    Integer selectType(Integer type,Long creditMainAuto);

    /**
     * 客户汇款输入：删除汇款明细
     * @param loginUserId
     * @param bookCarIncomeAuto
     * @return
     */
    Integer deleteIncome(Long loginUserId,Long bookCarIncomeAuto);

    /**
     * 客户汇款输入：删除附件明细
     * @param loginUserId
     * @param fileUploadAuto
     * @return
     */
    Integer deleteFile(Long loginUserId,Long fileUploadAuto);

    /**
     * 拨款申请作业：查询按钮
     * @param paymentQueryParam
     * @return
     */
    List<GrantList> selectGrantList(PaymentQueryParam paymentQueryParam);

    /**
     * 拨款申请作业：车款暂借明细
     * @param creditMainAuto
     * @param isAppropriation
     * @return
     */
    List<CarZjList> selectCarZjList(Long creditMainAuto,Integer isAppropriation);

    /**
     * 拨款申请作业：开户行列表
     * @param bankNameQueryParam
     * @return
     */
    List<BankNameList> selectBankNames(BankNameQueryParam bankNameQueryParam);
}
