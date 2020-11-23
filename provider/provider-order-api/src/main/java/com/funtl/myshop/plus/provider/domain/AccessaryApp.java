package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "[AccessaryApp]")
public class AccessaryApp implements Serializable {
    @Column(name = "AccessaryApp_Auto")
    private Long accessoryAppAuto;

    /**
    * 请款单号
    */
    @Column(name = "Request_Auto")
    private Long requestAuto;

    /**
    * 配件审核意见
    */
    @Column(name = "AccessaryAppMemo")
    private String accessoryAppMemo;

    /**
    * 审核状态
    */
    @Column(name = "AccessaryAppstatus")
    private Integer accessoryAppStatus;

    /**
    * (0:无代理;1:代理)
    */
    @Column(name = "IsAgent")
    private Integer isAgent;

    /**
    * 配件审核类别(0:派工单审核;1:配件请款审核)
    */
    @Column(name = "AccessaryAppType")
    private Integer accessoryAppType;

    /**
    * 审核人
    */
    @Column(name = "AccessaryAppPerson")
    private Long accessoryAppPerson;

    /**
    * 审核日期
    */
    @Column(name = "AccessaryAppDate")
    private Date accessoryAppDate;

    @Column(name = "AccessoriesWork_Auto")
    private Long accessoriesWorkAuto;

    /**
    * 审核顺序
    */
    @Column(name = "AccessoriesAppSeq")
    private Integer accessoriesAppSeq;

    private static final long serialVersionUID = 1L;
}
