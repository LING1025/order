package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "代理数据")
public class SelfAgentList implements Serializable {

    @ApiModelProperty(value = "代理人绑定表id")
    private Long creditAgentAuto;

    @ApiModelProperty(value = "本人id")
    private Long selfUser;

    @ApiModelProperty(value = "本人姓名")
    private String selfName;

    @ApiModelProperty(value = "本人单位id")
    private Long selfUSerDept;

    @ApiModelProperty(value = "本人单位")
    private String selfDept;

    @ApiModelProperty(value = "代理人id")
    private Long agentUser;

    @ApiModelProperty(value = "代理人姓名")
    private String agentName;

    @ApiModelProperty(value = "代理人部门id")
    private Long agentUserDept;

    @ApiModelProperty(value = "代理人部门")
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
    @ApiModelProperty(value = "本人角色集合")
    private List<SelfRoles> selfRolesList;

    @ApiModelProperty(value = "代理人角色集合")
    private List<AgentRoles> agentRolesList;
}
