package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[OrdersFee]")
public class OrdersFee implements Serializable {
    @Id
    @Column(name = "OrdersFee_Auto")
    private Long ordersFeeAuto;

    @Column(name = "Orders_Auto")
    private Long ordersAuto;

    /**
    * 公司别
    */
    @Column(name = "Inc_Auto")
    private Long incAuto;

    /**
    * 费用别
    */
    @Column(name = "FeeType_Auto")
    private Integer feeTypeAuto;

    @Column(name = "FeeAmt")
    private BigDecimal feeAmt;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Cuser")
    private Long cuser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "Muser")
    private Long muser;

    @Column(name = "MDT")
    private Date mdt;

    @Column(name = "Memo")
    private String memo;

    private static final long serialVersionUID = 1L;
}
