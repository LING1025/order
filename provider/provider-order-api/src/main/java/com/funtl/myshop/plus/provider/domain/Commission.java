package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[Commission]")
public class Commission implements Serializable {
    @Id
    @Column(name = "Commission_Auto")
    private Long commissionAuto;

    @Column(name = "Orders_Auto")
    private Long ordersAuto;

    @Column(name = "PushMan")
    private String pushMan;

    @Column(name = "PushTEL")
    private String pushTel;

    @Column(name = "PushAmt")
    private Long pushAmt;

    @Column(name = "PushMemo")
    private String pushMemo;

    @Column(name = "CUser")
    private Long cuser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "MUser")
    private Long muser;

    @Column(name = "MDT")
    private Date mdt;

    @Column(name = "PushStatus")
    private Integer pushStatus;

    /**
    * 佣金人信息编号
    */
    @Column(name = "CommPush_Auto")
    private Long commPushAuto;

    /**
    * 打款日
    */
    @Column(name = "PushAmtDT")
    private Date pushAmtDt;

    @Column(name = "PushRelation")
    private Integer pushRelation;

    private static final long serialVersionUID = 1L;
}
