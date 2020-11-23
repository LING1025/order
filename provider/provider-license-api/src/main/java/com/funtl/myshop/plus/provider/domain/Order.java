package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[Order]")
public class Order implements Serializable {
    /**
     * 申購序號
     */
    @Id
    @Column(name = "Order_Auto")
    private Long orderAuto;

    /**
     * 试算单号
     */
    @Column(name = "Orders_Auto")
    private Long ordersAuto;

    /**
     * 對象序號
     */
    @Column(name = "TradeItem_Auto")
    private Long tradeItemAuto;

    /**
     * 车籍序號
     */
    @Column(name = "CarBase_Auto")
    private Long carBaseAuto;

    /**
     * 業務序號
     */
    @Column(name = "Sales_Auto")
    private Long salesAuto;

    /**
     * 租赁期数
     */
    @Column(name = "MM")
    private Integer mm;

    /**
     * 月租金
     */
    @Column(name = "MAmt")
    private BigDecimal mAmt;

    /**
     * 契约编号
     */
    @Column(name = "OrderNo")
    private String orderNo;

    /**
     * 合约编号
     */
    @Column(name = "LinceNo")
    private String linceNo;

    /**
     * 起租日
     */
    @Column(name = "StartDT")
    private Date startDT;

    /**
     * 迄租日
     */
    @Column(name = "EndDT")
    private Date endDT;

    /**
     * 解約日
     */
    @Column(name = "ResDT")
    private Date resDT;

    /**
     * 申購狀態
     */
    @Column(name = "Status")
    private Integer status;

    /**
     * 備註
     */
    @Column(name = "Memo")
    private String memo;

    /**
     * 厂牌
     */
    @Column(name = "Brand_Auto")
    private Integer brandAuto;

    /**
     * 车型
     */
    @Column(name = "Clasen_Auto")
    private Integer clasenAuto;

    /**
     * 车辆牌价
     */
    @Column(name = "ListPrice")
    private BigDecimal listPrice;

    /**
     * 折价金額
     */
    @Column(name = "DisPrice")
    private BigDecimal disPrice;

    /**
     * 车辆进价
     */
    @Column(name = "GetPrice")
    private BigDecimal getPrice;

    /**
     * 配件金额
     */
    @Column(name = "Accessary")
    private BigDecimal accessary;

    /**
     * 推介佣金
     */
    @Column(name = "PushMoney")
    private BigDecimal pushMoney;

    /**
     * 车辆成本
     */
    @Column(name = "CarCost")
    private BigDecimal carCost;

    /**
     * 承租车价
     */
    @Column(name = "RentAmt")
    private BigDecimal rentAmt;

    /**
     * 预估残值
     */
    @Column(name = "OverAmt")
    private BigDecimal overAmt;

    /**
     * 保证金
     */
    @Column(name = "DptAmt")
    private BigDecimal dptAmt;

    /**
     * 车牌号码
     */
    @Column(name = "MakNo")
    private String makNo;

    /**
     * 车辆购置税
     */
    @Column(name = "CarTax")
    private BigDecimal carTax;

    /**
     * 车險座位别
     */
    @Column(name = "InsurePercnt")
    private Integer insurePercnt;

    /**
     * 车險性質别
     */
    @Column(name = "IsBusiness")
    private Integer isBusiness;

    /**
     * 租賃性質::itemcode.itemtype=236
     */
    @Column(name = "RentType")
    private Integer rentType;

    /**
     * 使用性質
     */
    @Column(name = "UseType")
    private Integer useType;

    /**
     * 車輛來源
     */
    @Column(name = "CarSource")
    private Integer carSource;

    /**
     * 代聘司機費用
     */
    @Column(name = "DriverAmt")
    private BigDecimal driverAmt;

    /**
     * 含油金額
     */
    @Column(name = "OilAmt")
    private BigDecimal oilAmt;

    /**
     * 代駕服務
     */
    @Column(name = "DriveService")
    private BigDecimal driveService;

    /**
     * 维修計價里程
     */
    @Column(name = "RateKM")
    private BigDecimal rateKM;

    /**
     * 維修合約里程
     */
    @Column(name = "LinceKM")
    private BigDecimal linceKM;

    /**
     * 維修月費用
     */
    @Column(name = "CarMtnAmt")
    private BigDecimal carMtnAmt;

    /**
     * 維修輪胎數
     */
    @Column(name = "whiel")
    private Integer whiel;

    /**
     * 超里程費用
     */
    @Column(name = "OverKM")
    private BigDecimal overKM;

    /**
     * 超里程結帳方式
     */
    @Column(name = "OverKMPayType")
    private Integer overKMPayType;

    /**
     * 付款周期
     */
    @Column(name = "PayMode")
    private Integer payMode;

    /**
     * 付款天數
     */
    @Column(name = "PayDay")
    private Integer payDay;

    /**
     * 計價利率
     */
    @Column(name = "RateRate")
    private BigDecimal rateRate;

    /**
     * 計價交強險
     */
    @Column(name = "RateInsure")
    private BigDecimal rateInsure;

    /**
     * 計價商業險
     */
    @Column(name = "RateInsureD")
    private BigDecimal rateInsured;

    /**
     * 計價月費用
     */
    @Column(name = "RateMCost")
    private BigDecimal rateMCost;

    /**
     * 計價年費用
     */
    @Column(name = "RateYCost")
    private BigDecimal rateYCost;

    /**
     * 計價次費用
     */
    @Column(name = "RateTCost")
    private BigDecimal rateTCost;

    /**
     * 計價月租金
     */
    @Column(name = "RateM")
    private BigDecimal rateM;

    /**
     * 計價年租金
     */
    @Column(name = "RateY")
    private BigDecimal rateY;

    /**
     * 計價次租金
     */
    @Column(name = "RateT")
    private BigDecimal rateT;

    /**
     * 計價未稅費用月租金
     */
    @Column(name = "RateCost")
    private BigDecimal rateCost;

    /**
     * 計價未稅折舊月租金
     */
    @Column(name = "RateDPN")
    private BigDecimal rateDPN;

    /**
     * 計價稅額
     */
    @Column(name = "RateTax")
    private BigDecimal rateTax;

    /**
     * 計價含稅月租金
     */
    @Column(name = "RateAmt")
    private BigDecimal rateAmt;

    /**
     * 成交利率
     */
    @Column(name = "FinalRate")
    private BigDecimal finalRate;

    /**
     * 成交交強險
     */
    @Column(name = "FinalInsure")
    private BigDecimal finalInsure;

    /**
     * 成交商業險
     */
    @Column(name = "FinalInsureD")
    private BigDecimal finalInsured;

    /**
     * 成交月費用
     */
    @Column(name = "FinalMCost")
    private BigDecimal finalMCost;

    /**
     * 成交年費用
     */
    @Column(name = "FinalYCost")
    private BigDecimal finalYCost;

    /**
     * 成交次費用
     */
    @Column(name = "FinalTCost")
    private BigDecimal finalTCost;

    /**
     * 成交月租金
     */
    @Column(name = "FinalM")
    private BigDecimal finalM;

    /**
     * 成交年租金
     */
    @Column(name = "FinalY")
    private BigDecimal finalY;

    /**
     * 成交次租金
     */
    @Column(name = "FinalT")
    private BigDecimal finalT;

    /**
     * 成交未稅費用月租金
     */
    @Column(name = "FinalCost")
    private BigDecimal finalCost;

    /**
     * 成交未稅折舊月租金
     */
    @Column(name = "FinalDPN")
    private BigDecimal finalDPN;

    /**
     * 成交稅額
     */
    @Column(name = "FinalTax")
    private BigDecimal finalTax;

    /**
     * 成交含稅月租金
     */
    @Column(name = "FinalAmt")
    private BigDecimal finalAmt;

    /**
     * 未稅租金總額
     */
    @Column(name = "RentTotal")
    private BigDecimal rentTotal;

    /**
     * 未稅毛利總額
     */
    @Column(name = "GrossMarginT")
    private BigDecimal grossMarginT;

    /**
     * 毛利率
     */
    @Column(name = "GrossMargin")
    private BigDecimal grossMargin;

    /**
     * 計價成交利率
     */
    @Column(name = "RentRate")
    private BigDecimal rentRate;

    /**
     * 建立人
     */
    @Column(name = "CUser")
    private Integer cUser;

    /**
     * 建立時間
     */
    @Column(name = "CDT")
    private Date cDT;

    /**
     * 修改人
     */
    @Column(name = "MUser")
    private Integer mUser;

    /**
     * 修改時間
     */
    @Column(name = "MDT")
    private Date mDT;

    /**
     * 客戶來源::
     */
    @Column(name = "CustSource")
    private Integer custSource;

    /**
     * 代步車每日費用
     */
    @Column(name = "Arrange")
    private BigDecimal arrange;

    /**
     * 每年代步車天數
     */
    @Column(name = "ArrangeDay")
    private Long arrangeDay;

    /**
     * 公司別
     */
    @Column(name = "Inc_Auto")
    private Long incAuto;

    /**
     * 實際利率
     */
    @Column(name = "RealRate")
    private BigDecimal realRate;

    /**
     * 實際毛利總額
     */
    @Column(name = "RealGMT")
    private BigDecimal realGMT;

    /**
     * 實際毛利率
     */
    @Column(name = "RealGM")
    private BigDecimal realGM;

    /**
     * 實際成交利率
     */
    @Column(name = "RealRentRate")
    private BigDecimal realRentRate;

    /**
     * 購牌費
     */
    @Column(name = "MakNoCost")
    private BigDecimal makNoCost;

    /**
     * 牌照殘值
     */
    @Column(name = "MakNoOverAmt")
    private BigDecimal makNoOverAmt;

    /**
     * 試算表
     */
    @Column(name = "A1")
    private String a1;

    /**
     * 合約1
     */
    @Column(name = "B1")
    private String b1;

    /**
     * 合約2
     */
    @Column(name = "B2")
    private String b2;

    /**
     * 合約3
     */
    @Column(name = "B3")
    private String b3;

    /**
     * 合約4
     */
    @Column(name = "B4")
    private String b4;

    /**
     * 資料確認
     */
    @Column(name = "IsCHK")
    private Integer isChk;

    /**
     * 业务类别::itemcode.itemtype=326
     */
    @Column(name = "OrderType")
    private Integer orderType;

    /**
     * 每月發票開立日::234
     */
    @Column(name = "InvDT")
    private Integer invDT;

    /**
     * 發票開立狀態
     */
    @Column(name = "InvStop")
    private Integer invStop;

    /**
     * 發票停開原因
     */
    @Column(name = "InvStopMemo")
    private String invStopMemo;

    /**
     * 印花稅
     */
    @Column(name = "StampTax")
    private BigDecimal stampTax;

    /**
     * 售車增值稅
     */
    @Column(name = "SellCarTax")
    private BigDecimal sellCarTax;

    /**
     * IRR
     */
    @Column(name = "IRR")
    private BigDecimal irr;

    /**
     * NPV
     */
    @Column(name = "NPV")
    private BigDecimal npv;

    /**
     * 過戶費
     */
    @Column(name = "TrnsFee")
    private BigDecimal trnsFee;

    @Column(name = "NeedFile")
    private Long needFile;

    @Column(name = "MakeFile")
    private Long makeFile;

    @Column(name = "NeedFileNum")
    private Long needFileNum;

    @Column(name = "MakeFileNum")
    private Long makeFileNum;

    /**
     * 實際承租價
     */
    @Column(name = "RentAmtReal")
    private BigDecimal rentAmtReal;

    /**
     * 主单序号
     */
    @Column(name = "Sub_Auto")
    private Long subAuto;

    /**
     * 固定资产金额
     */
    @Column(name = "RealCarCost")
    private BigDecimal realCarCost;

    @Column(name = "CollMemo")
    private String collMemo;

    /**
     * 资产月租金
     */
    @Column(name = "DPNMAmt")
    private BigDecimal dpnMAmt;

    @Column(name = "IncVirCardNo")
    private String incVirCardNo;

    @Column(name = "RealDptAmt")
    private BigDecimal realDptAmt;

    @Column(name = "RealDptDT")
    private Date realDptDT;

    @Column(name = "RealDptISPrinter")
    private Integer realDptISprinter;

    @Column(name = "DptPrinterDT")
    private Date dptPrinterDT;

    @Column(name = "DptRemark")
    private String dptRemark;

    @Column(name = "OrderMemo")
    private String orderMemo;

    @Column(name = "C1")
    private String c1;

    @Column(name = "C2")
    private String c2;

    @Column(name = "C3")
    private String c3;

    @Column(name = "D1")
    private String d1;

    @Column(name = "D2")
    private String d2;

    @Column(name = "D3")
    private String d3;

    @Column(name = "D4")
    private String d4;

    @Column(name = "D5")
    private String d5;

    @Column(name = "TaxMode")
    private Integer taxMode;

    @Column(name = "TaxRate")
    private BigDecimal taxRate;

    @Column(name = "chkListPrice")
    private Integer chkListPrice;

    @Column(name = "BoundDT")
    private Date boundDT;

    @Column(name = "BoundStatus")
    private Integer boundStatus;

    @Column(name = "JCDT")
    private Date jcDT;

    /**
     * 是否发票据奖金
     */
    @Column(name = "IsMerit")
    private Integer isMerit;

    /**
     * 展期日
     */
    @Column(name = "RunDT")
    private Date runDT;

    @Column(name = "YJCDT")
    private Date yjcDT;

    @Column(name = "YJSales")
    private Integer yjSales;

    @Column(name = "YJOrg")
    private Integer yjOrg;

    @Column(name = "Scooter")
    private String scooter;

    @Column(name = "DisType")
    private Integer disType;

    @Column(name = "InvStopEndDT")
    private Date invStopendDT;

    @Column(name = "IsBonus")
    private Integer isBonus;

    @Column(name = "IsRemoveOverdue")
    private Integer isRemoveOverdue;

    @Column(name = "BonusStatus")
    private Integer bonusStatus;

    @Column(name = "BonusYY")
    private Integer bonusYY;

    @Column(name = "BonusMM")
    private Integer bonusMM;

    @Column(name = "BonusAmt")
    private BigDecimal bonusAmt;

    @Column(name = "IsLawEnd")
    private Integer isLawEnd;

    @Column(name = "ReletMakno")
    private String reletMakNo;

    @Column(name = "IsRelet")
    private Integer isRelet;

    @Column(name = "DptAmtTrnDT")
    private Date dptAmtTrnDT;

    @Column(name = "BonusRate")
    private BigDecimal bonusRate;

    @Column(name = "BonusCarCost")
    private BigDecimal bonusCarCost;

    @Column(name = "IsBlack")
    private Integer isBlack;

    @Column(name = "BlackDT")
    private Date blackDT;

    @Column(name = "OutFee")
    private BigDecimal outFee;

    @Column(name = "FinanceFee")
    private BigDecimal financeFee;

    @Column(name = "UrgentFee")
    private BigDecimal urgentFee;

    @Column(name = "QJRemark")
    private String qJRemark;

    private static final long serialVersionUID = 1L;
}
