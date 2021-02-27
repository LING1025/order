package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[PurchaseRequest]")
public class PurchaseRequest implements Serializable {
    /**
    * 请款单号
    */
    @Id
    @Column(name = "PurchaseRequest_Auto")
    private Long purchaseRequestAuto;

    /**
    * 公司别
    */
    @Column(name = "Inc_Auto")
    private Long incAuto;

    /**
    * 发票号码
    */
    @Column(name = "Invoice_Number")
    private String invoiceNumber;

    /**
    * 请款人
    */
    @Column(name = "RequestUser")
    private Long requestUser;

    /**
    * 请款类别
    */
    @Column(name = "Request_Type")
    private Integer requestType;

    /**
    * 请款日期
    */
    @Column(name = "RequestDT")
    private Date requestDT;

    /**
    * 请款总金额(发票金额)
    */
    @Column(name = "RequestAmt")
    private BigDecimal requestAmt;

    /**
    * 实际请款金额(请款总金额-暂借款金额)
    */
    @Column(name = "PayRequestAmt")
    private BigDecimal payRequestAmt;

    /**
    * 是否暂借(0:不1:是)
    */
    @Column(name = "Is_ZJ")
    private Integer isZJ;

    /**
    * 暂借金额
    */
    @Column(name = "ZJAmt")
    private BigDecimal zJAmt;

    /**
    * 暂借付款别
    */
    @Column(name = "ZJpay_Type")
    private Integer zjPayType;

    /**
    * 付款别
    */
    @Column(name = "Pay_Type")
    private Integer payType;

    /**
    * 网银
    */
    @Column(name = "CyberBank_Type")
    private Integer cyBerBankType;

    /**
    * 领款人
    */
    @Column(name = "Payee")
    private String payee;

    /**
    * 领款人账号
    */
    @Column(name = "Payee_Account")
    private String payeeAccount;

    /**
    * 开户行
    */
    @Column(name = "BankName")
    private String bankName;

    /**
    * 请款备注
    */
    @Column(name = "Remark")
    private String remark;

    /**
    * 状态
    */
    @Column(name = "Status")
    private Integer status;

    /**
    * 与请款关联(0:否;1:是)
    */
    @Column(name = "Is_RR")
    private Integer isRR;

    @Column(name = "Cuser")
    private Long cuser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "Muser")
    private Long muser;

    @Column(name = "MDT")
    private Date mdt;

    /**
    * 现金、支票等领款公司别
    */
    @Column(name = "LKInc_Auto")
    private Long lKIncAuto;

    @Column(name = "IsBatch")
    private Integer isBatch;

    @Column(name = "BankType")
    private Integer bankType;

    @Column(name = "InvType")
    private Integer invType;

    @Column(name = "Is_Eas")
    private Integer isEas;

    /**
     * 用车申请序号
     */
    @Column(name = "Is_Eas")
    private Long carApplicationAuto;

    private static final long serialVersionUID = 1L;
}
