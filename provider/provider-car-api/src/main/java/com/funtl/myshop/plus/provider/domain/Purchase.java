package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "[Purchase]")
public class Purchase implements Serializable {
    /**
    * 请购请款物品序号(0:与请购关联；1:与请款关联)
    */
    @Id
    @Column(name = "Purchase_Auto")
    private Long purchaseAuto;

    /**
    * 物品名称
    */
    @Column(name = "Purchase_Name")
    private String purchaseName;

    /**
    * 请款物品对应的请购单号
    */
    @Column(name = "PurchaseRequisition_Auto")
    private Long purchaseRequisitionAuto;

    /**
    * 请购请款类别(0:请购1:请款)
    */
    @Column(name = "Type")
    private Integer type;

    /**
    * 请购单号或请款单号
    */
    @Column(name = "RR_Auto")
    private Long rrAuto;

    /**
    * 规格
    */
    @Column(name = "Purchase_Specifications")
    private String purchaseSpecifications;

    /**
    * 用途
    */
    @Column(name = "Purchase_Application")
    private String purchaseApplication;

    /**
    * 单价
    */
    @Column(name = "Purchase_Price")
    private BigDecimal purchasePrice;

    /**
    * 数量
    */
    @Column(name = "Purchase_Amount")
    private Integer purchaseAmount;

    /**
    * 备注
    */
    @Column(name = "Purchase_Remark")
    private String purchaseRemark;

    /**
    * 单个物品总额
    */
    @Column(name = "Purchase_TotalAmt")
    private BigDecimal purchaseTotalAmt;

    @Column(name = "Cuser")
    private Long cuser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "Muser")
    private Long muser;

    @Column(name = "MDT")
    private Date mdt;

    /**
    * 使用部门
    */
    @Column(name = "UseDep")
    private Long useDep;

    /**
    * 费用别
    */
    @Column(name = "FeeType")
    private Integer feeType;

    @Column(name = "PurchaseInvType")
    private Integer purchaseInvType;

    @Column(name = "InvNO")
    private String invNo;

    @Column(name = "TaxAmt")
    private BigDecimal taxAmt;

    @Column(name = "NOTaxAmt")
    private BigDecimal noTaxAmt;

    @Column(name = "ZJPurchase_Auto")
    private Long zjPurchaseAuto;

    /**
    * 开始时间
    */
    @Column(name = "start_time")
    private Date startTime;

    /**
    * 结束时间
    */
    @Column(name = "end_time")
    private Date endTime;

    /**
    * 费用时间
    */
    @Column(name = "fee_time")
    private Date feeTime;

    /**
    * 附件图片
    */
    @Column(name = "img")
    private String img;

    private static final long serialVersionUID = 1L;
}
