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
    private String orderNo;

    /**
     * 合约编号
     */
    private String linceNo;

    /**
     * 起租日
     */
    private Date startDT;

    /**
     * 迄租日
     */
    private Date endDT;

    /**
     * 解約日
     */
    private Date resDT;

    /**
     * 申購狀態
     */
    private Integer status;

    /**
     * 備註
     */
    private String memo;

    /**
     * 厂牌
     */
    private Integer brandAuto;

    /**
     * 车型
     */
    private Integer clasenAuto;

    /**
     * 车辆牌价
     */
    private BigDecimal listPrice;

    /**
     * 折价金額
     */
    private BigDecimal disPrice;

    /**
     * 车辆进价
     */
    private BigDecimal getPrice;

    /**
     * 配件金额
     */
    private BigDecimal accessary;

    /**
     * 推介佣金
     */
    private BigDecimal pushMoney;

    /**
     * 车辆成本
     */
    private BigDecimal carCost;

    /**
     * 承租车价
     */
    private BigDecimal rentAmt;

    /**
     * 预估残值
     */
    private BigDecimal overAmt;

    /**
     * 保证金
     */
    private BigDecimal dptAmt;

    /**
     * 车牌号码
     */
    private String makNo;

    /**
     * 车辆购置税
     */
    private BigDecimal carTax;

    /**
     * 车險座位别
     */
    private Integer insurePercnt;

    /**
     * 车險性質别
     */
    private Integer isBusiness;

    /**
     * 租賃性質::itemcode.itemtype=236
     */
    private Integer rentType;

    /**
     * 使用性質
     */
    private Integer useType;

    /**
     * 車輛來源
     */
    private Integer carSource;

    /**
     * 代聘司機費用
     */
    private BigDecimal driverAmt;

    /**
     * 含油金額
     */
    private BigDecimal oilAmt;

    /**
     * 代駕服務
     */
    private BigDecimal driveService;

    /**
     * 维修計價里程
     */
    private BigDecimal rateKM;

    /**
     * 維修合約里程
     */
    private BigDecimal linceKM;

    /**
     * 維修月費用
     */
    private BigDecimal carMtnAmt;

    /**
     * 維修輪胎數
     */
    private Integer whiel;

    /**
     * 超里程費用
     */
    private BigDecimal overKM;

    /**
     * 超里程結帳方式
     */
    private Integer overKMPayType;

    /**
     * 付款周期
     */
    private Integer payMode;

    /**
     * 付款天數
     */
    private Integer payDay;

    /**
     * 計價利率
     */
    private BigDecimal rateRate;

    /**
     * 計價交強險
     */
    private BigDecimal rateInsure;

    /**
     * 計價商業險
     */
    private BigDecimal rateInsured;

    /**
     * 計價月費用
     */
    private BigDecimal rateMCost;

    /**
     * 計價年費用
     */
    private BigDecimal rateYCost;

    /**
     * 計價次費用
     */
    private BigDecimal rateTCost;

    /**
     * 計價月租金
     */
    private BigDecimal rateM;

    /**
     * 計價年租金
     */
    private BigDecimal rateY;

    /**
     * 計價次租金
     */
    private BigDecimal rateT;

    /**
     * 計價未稅費用月租金
     */
    private BigDecimal rateCost;

    /**
     * 計價未稅折舊月租金
     */
    private BigDecimal rateDPN;

    /**
     * 計價稅額
     */
    private BigDecimal rateTax;

    /**
     * 計價含稅月租金
     */
    private BigDecimal rateAmt;

    /**
     * 成交利率
     */
    private BigDecimal finalRate;

    /**
     * 成交交強險
     */
    private BigDecimal finalInsure;

    /**
     * 成交商業險
     */
    private BigDecimal finalInsured;

    /**
     * 成交月費用
     */
    private BigDecimal finalMCost;

    /**
     * 成交年費用
     */
    private BigDecimal finalYCost;

    /**
     * 成交次費用
     */
    private BigDecimal finalTCost;

    /**
     * 成交月租金
     */
    private BigDecimal finalM;

    /**
     * 成交年租金
     */
    private BigDecimal finalY;

    /**
     * 成交次租金
     */
    private BigDecimal finalT;

    /**
     * 成交未稅費用月租金
     */
    private BigDecimal finalCost;

    /**
     * 成交未稅折舊月租金
     */
    private BigDecimal finalDPN;

    /**
     * 成交稅額
     */
    private BigDecimal finalTax;

    /**
     * 成交含稅月租金
     */
    private BigDecimal finalAmt;

    /**
     * 未稅租金總額
     */
    private BigDecimal rentTotal;

    /**
     * 未稅毛利總額
     */
    private BigDecimal grossMarginT;

    /**
     * 毛利率
     */
    private BigDecimal grossMargin;

    /**
     * 計價成交利率
     */
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
    private Integer custSource;

    /**
     * 代步車每日費用
     */
    private BigDecimal arrange;

    /**
     * 每年代步車天數
     */
    private Long arrangeDay;

    /**
     * 公司別
     */
    private Long incAuto;

    /**
     * 實際利率
     */
    private BigDecimal realRate;

    /**
     * 實際毛利總額
     */
    private BigDecimal realGMT;

    /**
     * 實際毛利率
     */
    private BigDecimal realGM;

    /**
     * 實際成交利率
     */
    private BigDecimal realRentRate;

    /**
     * 購牌費
     */
    private BigDecimal makNoCost;

    /**
     * 牌照殘值
     */
    private BigDecimal makNoOverAmt;

    /**
     * 試算表
     */
    private String a1;

    /**
     * 合約1
     */
    private String b1;

    /**
     * 合約2
     */
    private String b2;

    /**
     * 合約3
     */
    private String b3;

    /**
     * 合約4
     */
    private String b4;

    /**
     * 資料確認
     */
    private Integer isChk;

    /**
     * 业务类别::itemcode.itemtype=326
     */
    private Integer orderType;

    /**
     * 每月發票開立日::234
     */
    private Integer invDT;

    /**
     * 發票開立狀態
     */
    private Integer invStop;

    /**
     * 發票停開原因
     */
    private String invStopMemo;

    /**
     * 印花稅
     */
    private BigDecimal stampTax;

    /**
     * 售車增值稅
     */
    private BigDecimal sellCarTax;

    /**
     * IRR
     */
    private BigDecimal irr;

    /**
     * NPV
     */
    private BigDecimal npv;

    /**
     * 過戶費
     */
    private BigDecimal trnsFee;

    private Long needFile;

    private Long makeFile;

    private Long needFileNum;

    private Long makeFileNum;

    /**
     * 實際承租價
     */
    private BigDecimal rentAmtReal;

    /**
     * 主单序号
     */
    private Long subAuto;

    /**
     * 固定资产金额
     */
    private BigDecimal realCarCost;

    private String collMemo;

    /**
     * 资产月租金
     */
    private BigDecimal dpnMAmt;

    private String incVirCardNo;

    private BigDecimal realDptAmt;

    private Date realDptDT;

    private Integer realDptISprinter;

    private Date dptPrinterDT;

    private String dptRemark;

    private String orderMemo;

    private String c1;

    private String c2;

    private String c3;

    private String d1;

    private String d2;

    private String d3;

    private String d4;

    private String d5;

    private Integer taxMode;

    private BigDecimal taxRate;

    private Integer chkListPrice;

    private Date boundDT;

    private Integer boundStatus;

    private Date jcDT;

    /**
     * 是否发票据奖金
     */
    private Integer isMerit;

    /**
     * 展期日
     */
    private Date runDT;

    private Date yjcDT;

    private Integer yjSales;

    private Integer yjOrg;

    private String scooter;

    private Integer disType;

    private Date invStopendDT;

    private Integer isBonus;

    private Integer isRemoveOverdue;

    private Integer bonusStatus;

    private Integer bonusYY;

    private Integer bonusMM;

    private BigDecimal bonusAmt;

    private Integer isLawEnd;

    private String reletMakNo;

    private Integer isRelet;

    private Date dptAmtTrnDT;

    private BigDecimal bonusRate;

    private BigDecimal bonusCarCost;

    private Integer isBlack;

    private Date blackDT;

    private static final long serialVersionUID = 1L;
}
