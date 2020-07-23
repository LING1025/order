package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[CreditAgent]")
public class CreditAgent implements Serializable {
    /**
     * 代理人绑定表id
     */
    @Id
    @Column(name = "CreditAgent_Auto")
    private Long creditAgentAuto;

    /**
     * 本人
     */
    @Column(name = "SelfUser")
    private Long selfUser;

    /**
     * 本人单位
     */
    @Column(name = "SelfUSerDept")
    private Long selfUSerDept;

    /**
     * 代理人
     */
    @Column(name = "AgentUser")
    private Long agentUser;

    /**
     * 代理人部门
     */
    @Column(name = "AgentUserDept")
    private Long agentUserDept;

    /**
     * 是否有效 0 停用  1正常 2删除
     */
    @Column(name = "IsOn")
    private Byte isOn;

    /**
     * 代理截止日期
     */
    @Column(name = "AgentCDate")
    private Date agentCDate;

    @Column(name = "CUser")
    private Integer cUser;

    @Column(name = "CDT")
    private Date cDT;

    @Column(name = "MUSer")
    private Integer mUSer;

    @Column(name = "MDT")
    private Date MDT;



    private static final long serialVersionUID = 1L;
}
