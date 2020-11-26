package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价：1、承办业代部门下拉选")
public class OrgNameSelect implements Serializable {
    @ApiModelProperty(value = "部门序号")
    private Long orgAuto;

    @ApiModelProperty(value = "部门名称")
    private String depName;
}
