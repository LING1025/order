package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AgentRoles implements Serializable {
    @ApiModelProperty(value = "代理人角色id")
    private Long agentRoleIds;

    @ApiModelProperty(value = "代理人角色名")
    private String agentRoleNames;
}
