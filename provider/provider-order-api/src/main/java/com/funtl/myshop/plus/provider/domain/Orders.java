package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "[Orders]")
public class Orders implements Serializable {
    /**
    * 试算单号
    */
    @Column(name = "Orders_Auto")
    private Long ordersAuto;

    /**+
     * .
    * 公司别代码::Inc.Inc_Auto
    */
    @Column(name = "Inc_Auto")
    private Long incAuto;

    /**
    * 客户代码::TradeItem.TradeItem_Auto
    */
    @Column(name = "TradeItem_Auto")
    private Long tradeItemAuto;

    /**
    * 车号代码::CarBase.CarBase_Auto
    */
    @Column(name = "CarBase_Auto")
    private Long carBaseAuto;

    /**
    * 业代::v_Emp2Role.UserId
    */
    @Column(name = "Sales_Auto")
    private Long salesAuto;

    /**
    * 客户来源::ItemCode.ItemType=313
    */
    @Column(name = "CustSource")
    private Integer custSource;

    @Column(name = "CustMemo")
    private String custMemo;

    /**
    * 车辆来源::ItemCode.ItemType=503
    */
    @Column(name = "CarSource")
    private Integer carSource;

    /**
    * 品牌::FactoryBrand_Auto
    */
    @Column(name = "FactoryBrand_Auto")
    private Integer factoryBrandAuto;

    /**
    * 厂牌::Brand.Brand_Auto
    */
    @Column(name = "Brand_Auto")
    private Integer brandAuto;

    /**
    * 车型::Clasen.Clasen_Auto
    */
    @Column(name = "Clasen_Auto")
    private Integer clasenAuto;

    /**
    * 车型代码
    */
    @Column(name = "ClasenCode")
    private String clasenCode;

    /**
    * 车色
    */
    @Column(name = "CarColor")
    private String carColor;

    /**
    * 出厂年月
    */
    @Column(name = "CarDT")
    private Date cardt;

    /**
    * 排气量
    */
    @Column(name = "CC")
    private Integer cc;

    /**
    * 车号
    */
    @Column(name = "MakNo")
    private String makNo;

    /**
    * 牌价
    */
    @Column(name = "ListPrice")
    private BigDecimal listPrice;

    /**
    * 折价
    */
    @Column(name = "DisPrice")
    private BigDecimal disPrice;

    /**
    * 进价
    */
    @Column(name = "GetPrice")
    private BigDecimal getPrice;

    /**
    * 配件金额
    */
    @Column(name = "Accessary")
    private BigDecimal accessary;

    /**
    * 佣金
    */
    @Column(name = "PushMoney")
    private BigDecimal pushMoney;

    @Column(name = "PushMan")
    private String pushMan;

    @Column(name = "PushMan_Auto")
    private Integer pushManAuto;

    @Column(name = "PushTEL")
    private String pushtel;

    /**
    * 购置税
    */
    @Column(name = "CarTax")
    private BigDecimal carTax;

    /**
    * 车辆成本
    */
    @Column(name = "CarCost")
    private BigDecimal carCost;

    /**
    * 残值
    */
    @Column(name = "OverAmt")
    private BigDecimal overAmt;

    /**
    * 保证金
    */
    @Column(name = "DptAmt")
    private BigDecimal dptAmt;

    /**
    * 上海牌
    */
    @Column(name = "MakNoType")
    private Integer makNoType;

    /**
    * 购牌费
    */
    @Column(name = "MakNoCost")
    private BigDecimal makNoCost;

    /**
    * 业务类别::ItemCode.ItemType=326
    */
    @Column(name = "OrderType")
    private Integer orderType;

    /**
    * 期数
    */
    @Column(name = "MM")
    private Integer mm;

    /**
    * 承租车价
    */
    @Column(name = "RentAmt")
    private BigDecimal rentAmt;

    /**
    * 租赁性质::ItemCode.ItemType=314
    */
    @Column(name = "RentType")
    private Integer rentType;

    /**
    * 印花税
    */
    @Column(name = "StampTax")
    private BigDecimal stampTax;

    /**
    * 售车税
    */
    @Column(name = "SellCarTax")
    private BigDecimal sellCarTax;

    /**
    * 过户费
    */
    @Column(name = "TrnsFee")
    private BigDecimal trnsFee;

    /**
    * 付款周期::ItemCode.ItemType=316
    */
    @Column(name = "PayMode")
    private Integer payMode;

    /**
    * 付款天数
    */
    @Column(name = "PayDay")
    private Integer payDay;

    /**
    * 车险性质别::ItemCode.ItemType=411
    */
    @Column(name = "InsureType")
    private Integer insureType;

    /**
    * 车險座位别::1.客车6座以下 2.客车6-10座 3.货车2吨以下 4.货车2-5吨
    */
    @Column(name = "InsurePercnt")
    private Integer insurePercnt;

    /**
    * 座位数
    */
    @Column(name = "Percnt")
    private Integer percnt;

    /**
    * 汽车产地::1.国产 2.进口
    */
    @Column(name = "CarPlace")
    private Integer carPlace;

    /**
    * 计价成本利率(%)::13
    */
    @Column(name = "RateRate")
    private BigDecimal rateRate;

    /**
    * 实际成交价利率(%)
    */
    @Column(name = "FinalRate")
    private BigDecimal finalRate;

    @Column(name = "RateMCost")
    private BigDecimal rateMCost;

    @Column(name = "RateYCost")
    private BigDecimal rateYCost;

    @Column(name = "RateTCost")
    private BigDecimal rateTCost;

    @Column(name = "RateM")
    private BigDecimal ratem;

    @Column(name = "RateY")
    private BigDecimal ratey;

    @Column(name = "RateT")
    private BigDecimal ratet;

    @Column(name = "RateCost")
    private BigDecimal rateCost;

    /**
    * 折旧月租金
    */
    @Column(name = "RateDPN")
    private BigDecimal rateDpn;

    @Column(name = "RateTax")
    private BigDecimal rateTax;

    @Column(name = "RateAmt")
    private BigDecimal rateAmt;

    @Column(name = "FinalMCost")
    private BigDecimal finalMCost;

    @Column(name = "FinalYCost")
    private BigDecimal finalYCost;

    @Column(name = "FinalTCost")
    private BigDecimal finalTCost;

    @Column(name = "FinalM")
    private BigDecimal finalm;

    @Column(name = "FinalY")
    private BigDecimal finaly;

    @Column(name = "FinalT")
    private BigDecimal finalt;

    @Column(name = "FinalCost")
    private BigDecimal finalCost;

    @Column(name = "FinalDPN")
    private BigDecimal finalDpn;

    @Column(name = "FinalTax")
    private BigDecimal finalTax;

    @Column(name = "FinalAmt")
    private BigDecimal finalAmt;

    @Column(name = "MAmt")
    private BigDecimal mAmt;

    @Column(name = "RentAmtT")
    private BigDecimal rentAmtt;

    @Column(name = "RentRate")
    private BigDecimal rentRate;

    @Column(name = "GrossMargin")
    private BigDecimal grossMargin;

    @Column(name = "GrossMarginT")
    private BigDecimal grossMargint;

    @Column(name = "OrderStatus")
    private Integer orderStatus;

    @Column(name = "Memo")
    private String memo;

    @Column(name = "TaxMode")
    private Integer taxMode;

    /**
    * 税率
    */
    @Column(name = "TaxRate")
    private BigDecimal taxRate;

    @Column(name = "chkListPrice")
    private Integer chkListPrice;

    @Column(name = "CUser")
    private Integer cuser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "MUser")
    private Integer muser;

    @Column(name = "MDT")
    private Date mdt;

    @Column(name = "LinceKM")
    private Integer linceKm;

    @Column(name = "AppDate")
    private Date appDate;

    /**
    * 附件1
    */
    @Column(name = "A1")
    private String a1;

    /**
    * 附件2
    */
    @Column(name = "A2")
    private String a2;

    /**
    * 附件3
    */
    @Column(name = "A3")
    private String a3;

    /**
    * 附件4
    */
    @Column(name = "A4")
    private String a4;

    /**
    * 附件5
    */
    @Column(name = "A5")
    private String a5;

    /**
    * 原试算单号
    */

    @Column(name = "Orders_Old")
    private Long ordersOld;

    @Column(name = "PostType")
    private Integer postType;

    @Column(name = "ISContractLock")
    private Integer isContractLock;

    @Column(name = "LockUser")
    private Long lockUser;

    @Column(name = "LockDT")
    private Date lockDt;

    @Column(name = "ISThirdParty")
    private Integer isThirdParty;

    @Column(name = "BsType")
    private Integer bsType;

    @Column(name = "NoInsure")
    private Integer noInsure;

    @Column(name = "IRR")
    private BigDecimal irr;

    @Column(name = "NPV")
    private BigDecimal npv;

    @Column(name = "IsCredit")
    private Integer isCredit;

    @Column(name = "IsCreditUser")
    private Integer isCredituser;

    @Column(name = "DptType")
    private Integer dptType;

    @Column(name = "Supplier_Buy")
    private Integer supplierBuy;

    @Column(name = "Project_Auto")
    private Long projectAuto;

    @Column(name = "Onetime")
    private Integer onetime;

    @Column(name = "RepurchaseAmt")
    private BigDecimal repurchaseAmt;

    @Column(name = "ISInsureOffer")
    private Integer isInsureOffer;

    @Column(name = "CostAdjustment")
    private BigDecimal costAdjustment;

    /**
    * 首付款开票付款方式::ItemCode.ItemType=333
    */
    @Column(name = "DptTaxPay")
    private Integer dptTaxPay;

    /**
    * 代垫利息成本
    */
    @Column(name = "DptTax")
    private BigDecimal dptTax;

    /**
    * 燃油种类::ItemCode.ItemType=231
    */
    @Column(name = "oil")
    private Integer oil;

    @Column(name = "IsCustomerCare")
    private Integer isCustomerCare;

    /**
    * 续租新车旧车号
    */
    @Column(name = "ReletMakno")
    private String reletMakno;

    /**
    * 续租新车否
    */
    @Column(name = "IsRelet")
    private Integer isRelet;

    @Column(name = "OnetimeTransfer")
    private BigDecimal onetimeTransfer;

    @Column(name = "OnetimePoundage")
    private BigDecimal onetimePoundage;

    @Column(name = "OverAmt_Y")
    private BigDecimal overamtY;

    @Column(name = "Budget01_Y")
    private BigDecimal budget01Y;

    @Column(name = "CarTransfer")
    private Integer carTransfer;

    @Column(name = "MakNo_INC")
    private String makNoInc;

    @Column(name = "Weight")
    private String weight;

    @Column(name = "MM2")
    private Integer mm2;

    @Column(name = "UseKM")
    private Integer usekm;

    /**
    * 服务费
    */
    @Column(name = "ServiceAmt")
    private BigDecimal serviceAmt;

    /**
    * 出库费
    */
    @Column(name = "OutFee")
    private BigDecimal outFee;

    /**
    * 金融费
    */
    @Column(name = "FinanceFee")
    private BigDecimal financeFee;

    @Column(name = "UrgentFee")
    private BigDecimal urgentFee;

    @Column(name = "MortgageAddr")
    private Integer mortgageAddr;

    @Column(name = "CommissionRate")
    private BigDecimal commissionRate;

    @Column(name = "RateTaxY")
    private BigDecimal rateTaxy;

    /**
    * 保险报告书
    */
    @Column(name = "A6")
    private String a6;

    /**
    * 保险保单
    */
    @Column(name = "A7")
    private String a7;

    @Column(name = "InsureAnomalyType")
    private Integer insureAnomalyType;

    @Column(name = "CarPriceRef")
    private Long carPriceRef;

    @Column(name = "IsBigTradeItem")
    private Integer isBigTradeItem;

    @Column(name = "CarExtensionAmt")
    private BigDecimal carextensionamt;

    @Column(name = "Discount")
    private BigDecimal discount;

    private static final long serialVersionUID = 1L;
}
