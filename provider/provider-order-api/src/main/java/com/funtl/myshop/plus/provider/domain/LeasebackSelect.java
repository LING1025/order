package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价：下拉选1")
public class LeasebackSelect implements Serializable {
    @ApiModelProperty(value = "回租报价")
    private String itemName;

    @ApiModelProperty(value = "回租报价对应的num")
    private Long num;

}
