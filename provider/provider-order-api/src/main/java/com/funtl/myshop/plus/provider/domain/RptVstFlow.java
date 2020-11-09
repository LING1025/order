package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[RptVstFlow]")
public class RptVstFlow implements Serializable {
    /**
     * 行程列表序号
     */
    @Id
    @Column(name = "RptVstFlow_Auto")
    private Long rptVstFlowAuto;

    /**
     * 行程单号
     */
    @Column(name = "RptVst_Auto")
    private Long rptVstAuto;

    @Column(name = "AppSeq")
    private Integer appSeq;

    /**
     * 权限id
     */
    @Column(name = "RoleID")
    private Integer roleID;

    /**
     * 状态
     */
    @Column(name = "Status")
    private Integer status;

    /**
     * 备注
     */
    @Column(name = "Memo")
    private String memo;

    /**
     * 是否代理 0 否 1是
     */
    @Column(name = "IsAgent")
    private Integer isAgent;

    @Column(name = "CUser")
    private Integer cUser;

    @Column(name = "CDT")
    private Date cDT;

    @Column(name = "MUser")
    private Integer mUser;

    @Column(name = "MDT")
    private Date mDT;

    private static final long serialVersionUID = 1L;
}
