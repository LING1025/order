package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AgentList implements Serializable {
    /**
     * 本人id（被代理）
     */
    @JsonIgnore
    private Long selfUser;

    @ApiModelProperty(value = "选择代理人")
    private String selfName;

    @ApiModelProperty(value = "选择权限")
    private List<SelfRoles> selfRolesList;
}
