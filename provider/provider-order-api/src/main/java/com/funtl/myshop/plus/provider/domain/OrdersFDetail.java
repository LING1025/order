package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[OrdersFDetail]")
public class OrdersFDetail implements Serializable {
    @Id
    @Column(name = "OrdersFDetail_Auto")
    private Long ordersFDetailAuto;

    @Column(name = "Orders_Auto")
    private Integer ordersAuto;

    @Column(name = "Memo")
    private String memo;

    @Column(name = "CreditPerson")
    private Integer creditPerson;

    @Column(name = "Orders_Status")
    private Integer ordersStatus;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "MDT")
    private Date mdt;

    @Column(name = "IsAgent")
    private Integer isAgent;

    @Column(name = "AgentPerson")
    private Integer agentPerson;

    @Column(name = "RoleID")
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}
