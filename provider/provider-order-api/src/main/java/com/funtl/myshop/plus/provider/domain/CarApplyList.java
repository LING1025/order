package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "使用部门、使用人数据")
public class CarApplyList implements Serializable {
    @ApiModelProperty(value = "使用部门序号")
    private Long orgAuto;

    @ApiModelProperty(value = "使用部门")
    private String orgName;

    @ApiModelProperty(value = "使用人序号")
    private Long userAuto;

    @ApiModelProperty(value = "使用人")
    private String username;
}
