package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AgentRoles implements Serializable {
    @ApiModelProperty(value = "角色id")
    private Long agentRoleIds;

    @ApiModelProperty(value = "角色名")
    private String agentRoleNames;
}
