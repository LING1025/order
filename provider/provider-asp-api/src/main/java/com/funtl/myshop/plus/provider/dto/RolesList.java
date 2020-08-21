package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "选择权限数据")
public class RolesList implements Serializable {
    @ApiModelProperty(value = "角色id")
    private Long rolesAuto;

    @ApiModelProperty(value = "角色名")
    private String roleName;
}
