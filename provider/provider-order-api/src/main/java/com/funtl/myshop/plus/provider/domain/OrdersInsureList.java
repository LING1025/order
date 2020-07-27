package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[OrdersInsureList]")
public class OrdersInsureList implements Serializable {
    @Id
    @Column(name = "OrdersInsureList_Auto")
    private Long ordersInsureListAuto;

    @Column(name = "Orders_Auto")
    private Long ordersAuto;

    @Column(name = "InsureYear")
    private Integer insureYear;

    @Column(name = "InsureType")
    private Integer insureType;

    @Column(name = "InsureRealAmt")
    private BigDecimal insureRealAmt;

    @Column(name = "InsureAmt")
    private BigDecimal insureAmt;

    @Column(name = "InsureDiscount")
    private BigDecimal insureDiscount;

    @Column(name = "InsureMemo")
    private String insureMemo;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "CUser")
    private Integer cuser;

    @Column(name = "InsureDpt")
    private Integer insureDpt;

    private static final long serialVersionUID = 1L;
}
