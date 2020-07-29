package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "[OrdersBudget]")
public class OrdersBudget implements Serializable {
    /**
    * 費用序號
    */
    @Column(name = "OrdersBudget_Auto")
    private Long ordersBudgetAuto;

    /**
    * 试算序號
    */
    @Column(name = "Orders_Auto")
    private Long ordersAuto;

    /**
    * 費用名稱序號::310
    */
    @Column(name = "Type_Auto")
    private Integer typeAuto;

    /**
    * 費用金額
    */
    @Column(name = "PA")
    private BigDecimal pa;

    /**
    * 費用次數
    */
    @Column(name = "PB")
    private BigDecimal pb;

    /**
    * 計價金額
    */
    @Column(name = "RateAmt")
    private BigDecimal rateAmt;

    /**
    * 計價月費用
    */
    @Column(name = "RateMAmt")
    private BigDecimal rateMAmt;

    /**
    * 成交金額
    */
    @Column(name = "FinalAmt")
    private BigDecimal finalAmt;

    /**
    * 成交月費用
    */
    @Column(name = "FinalMAmt")
    private BigDecimal finalMAmt;

    @Column(name = "Memo")
    private String memo;

    /**
    * 建立人
    */
    @Column(name = "CUser")
    private Integer cuser;

    /**
    * 建立時間
    */
    @Column(name = "CDT")
    private Date cdt;

    /**
    * 修改人
    */
    @Column(name = "MUser")
    private Integer muser;

    /**
    * 修改時間
    */
    @Column(name = "MDT")
    private Date mdt;

    private static final long serialVersionUID = 1L;
}
