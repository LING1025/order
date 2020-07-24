package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SelfAgentList implements Serializable {
    /**
     * 代理人绑定表id
     */
    private Long creditAgentAuto;

    /**
     * 本人
     */
    private Long selfUser;
    private String selfName;

    /**
     * 本人单位
     */
    private Long selfUSerDept;
    private String selfDept;

    /**
     * 代理人
     */
    private Long agentUser;
    private String agentName;

    /**
     * 代理人部门
     */
    private Long agentUserDept;
    private String agentDept;

    /**
     * 是否有效 0 停用  1正常 2删除
     */
//    private Byte isOn;

    /**
     * 代理截止日期
     */
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    private Date agentCDate;
    /**
     * 本人角色id\角色名
      */
    private List<Long> selfRoleIds;
    private List<String> selfRoleNames;
    /**
     * 代理人角色id\角色名
     */
    private List<Long> agentRoleIds;
    private List<String> agentRoleNames;
}
