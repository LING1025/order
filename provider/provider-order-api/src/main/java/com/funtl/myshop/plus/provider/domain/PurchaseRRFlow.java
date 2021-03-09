package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "[PurchaseRRFlow]")
public class PurchaseRRFlow implements Serializable {
    @Column(name = "PurchaseRRFlow_Auto")
    private Long purchaseRRFlowAuto;

    /**
    * 请购或请款单序号
    */
    @Column(name = "RR_Auto")
    private Long rrAuto;

    /**
    * 审核顺序
    */
    @Column(name = "AppSeq")
    private Integer appSeq;

    /**
    * 审核人序号
    */
    @Column(name = "AppUserID")
    private Long appUserId;

    /**
    * 当前审核阶段
    */
    @Column(name = "LevNow")
    private Integer levNow;

    /**
    * 审核状态
    */
    @Column(name = "Status")
    private Integer status;

    /**
    * 是否代理
    */
    @Column(name = "IsAgent")
    private Integer isAgent;

    /**
    * 代理人
    */
    @Column(name = "AgentUserID")
    private Long agentUserID;

    /**
    * 审核备注
    */
    @Column(name = "Memo")
    private String memo;

    /**
    * 审核日期
    */
    @Column(name = "AppDT")
    private Date appDT;

    @Column(name = "CUser")
    private Long cuser;

    @Column(name = "CDT")
    private Date cdt;

    /**
    * 驳回次数
    */
    @Column(name = "Reject")
    private Integer reject;

    /**
    * 请购请款类别(0:请购1:请款;2:OA暂借;3:GPS暂借)
    */
    @Column(name = "Type")
    private Integer type;

    /**
    * 审核角色
    */
    @Column(name = "AppRole")
    private String appRole;

    private static final long serialVersionUID = 1L;
}
