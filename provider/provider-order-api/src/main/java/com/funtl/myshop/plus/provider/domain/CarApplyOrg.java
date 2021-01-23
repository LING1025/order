package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "使用部门数据")
public class CarApplyOrg implements Serializable {
    @ApiModelProperty(value = "使用部门序号")
    private Long orgAuto;

    @ApiModelProperty(value = "使用部门")
    private String orgName;
}
