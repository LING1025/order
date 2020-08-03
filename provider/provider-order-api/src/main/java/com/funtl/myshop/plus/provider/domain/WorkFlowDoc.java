package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[WorkFlowDoc]")
public class WorkFlowDoc implements Serializable {
    @Id
    @Column(name = "WorkFlowDoc_Auto")
    private Long workFlowDocAuto;

    @Column(name = "WorkFlow_Auto")
    private Long workFlowAuto;

    @Column(name = "WorkFlowD_Auto")
    private Long workFlowDAuto;

    @Column(name = "DocPostID")
    private Long docPostID;

    @Column(name = "AppSeq")
    private Integer appSeq;

    @Column(name = "RoleID")
    private Integer roleId;

    @Column(name = "MaxLevel")
    private Integer maxLevel;

    @Column(name = "LevNow")
    private Integer levNow;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "IsOver")
    private Integer isOver;

    @Column(name = "Rights")
    private Integer rights;

    @Column(name = "DefaultStatus")
    private Integer defaultStatus;

    @Column(name = "InActiveList")
    private Integer inActiveList;

    @Column(name = "LimitDept")
    private Integer limitDept;

    @Column(name = "IsAgent")
    private Integer isAgent;

    @Column(name = "Memo")
    private String memo;

    @Column(name = "CUser")
    private Integer cuser;

    @Column(name = "MUser")
    private Integer muser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "MDT")
    private Date mdt;

    private static final long serialVersionUID = 1L;
}
