package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价：客户全称列表")
public class FNames implements Serializable {
    @ApiModelProperty(value = "客户序号")
    private Long tradeItemAuto;

    @ApiModelProperty(value = "客户别")
    private String fName;
}
