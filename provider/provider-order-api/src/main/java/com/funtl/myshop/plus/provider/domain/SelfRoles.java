package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "本人数据")
public class SelfRoles implements Serializable {

    @ApiModelProperty(value = "角色id")
    private Long selfRoleIds;

    @ApiModelProperty(value = "角色名")
    private String selfRoleNames;
}
