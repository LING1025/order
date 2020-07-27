package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[OrdersInsure_Years]")
public class OrdersInsureYears implements Serializable {
    @Id
    @Column(name = "OrdersInsure_Years_Auto")
    private Long ordersInsureYearsAuto;

    @Column(name = "Orders_Auto")
    private Long ordersAuto;

    /**
    * 承保險別
    */
    @Column(name = "InsureType")
    private Integer insureType;

    /**
    * 保額
    */
    @Column(name = "InsureLimit")
    private BigDecimal insureLimit;

    /**
    * 承保人數
    */
    @Column(name = "InsurePercnt")
    private Integer insurePercnt;

    /**
    * 不計免賠
    */
    @Column(name = "DetailAmt")
    private BigDecimal detailAmt;

    /**
    * 原始保費
    */
    @Column(name = "OrgAmt")
    private BigDecimal orgAmt;

    /**
    * 計價保費
    */
    @Column(name = "RateAmt")
    private BigDecimal rateAmt;

    @Column(name = "Memo")
    private String memo;

    @Column(name = "CUser")
    private Integer cuser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "MUser")
    private Integer muser;

    @Column(name = "MDT")
    private Date mdt;

    @Column(name = "OfferAmt")
    private BigDecimal offerAmt;

    /**
    * 年度
    */
    @Column(name = "InsureYear")
    private Integer insureYear;

    @Column(name = "InsureMode")
    private Integer insureMode;

    /**
    * 牌价
    */
    @Column(name = "InsurePrice")
    private BigDecimal insurePrice;

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

    @Column(name = "CustomerCare")
    private Integer customerCare;

    private static final long serialVersionUID = 1L;
}
