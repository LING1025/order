package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[OrderBudget]")
public class OrderBudget implements Serializable {
    /**
    * 費用序號
    */
    @Column(name = "OrderBudget_Auto")
    private Long orderBudgetAuto;

    /**
    * 申購序號
    */
    @Column(name = "Order_Auto")
    private Long orderAuto;

    /**
    * 費用名稱序號::310
    */
    @Column(name = "Type_Auto")
    private Integer typeAuto;

    /**
    * 費用名稱
    */
    @Column(name = "TypeName")
    private String typeName;

    /**
    * 計費周期
    */
    @Column(name = "CountMode")
    private Integer countMode;

    /**
    * 費用金額
    */
    @Column(name = "Amt")
    private BigDecimal amt;

    /**
    * 費用次數
    */
    @Column(name = "Cou")
    private Integer cou;

    /**
    * 計價折數
    */
    @Column(name = "RateDis")
    private Integer rateDis;

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
    * 成交折數
    */
    @Column(name = "FinalDis")
    private Integer finalDis;

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

    /**
    * 實支金額
    */
    @Column(name = "RealAmt")
    private BigDecimal realAmt;

    /**
    * 實支月金額
    */
    @Column(name = "RealMAmt")
    private BigDecimal realMAmt;

    /**
    * 狀態
    */
    @Column(name = "Status")
    private Integer status;

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
    * 已沖金額
    */
    @Column(name = "ARAmt")
    private BigDecimal aRAmt;

    private static final long serialVersionUID = 1L;
}
