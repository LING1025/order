package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[OrdersStepwise]")
public class OrdersStepwise implements Serializable {
    @Id
    @Column(name = "OrdersStepwise_Auto")
    private Long ordersStepwiseAuto;

    @Column(name = "Orders_Auto")
    private Long ordersAuto;

    @Column(name = "MM_S")
    private Integer mmS;

    @Column(name = "MM_E")
    private Integer mmE;

    @Column(name = "StepwiseMAmt")
    private BigDecimal stepwiseMAmt;

    @Column(name = "CDT")
    private Date cDT;

    @Column(name = "CUser")
    private Long CUser;

    private static final long serialVersionUID = 1L;
}
