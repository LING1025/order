package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "配件明细数据")
public class AccessoryList implements Serializable {
    @ApiModelProperty(value = "厂商")
    private String supplierN;

    @ApiModelProperty(value = "次配件")
    private String subAccessory;

    @ApiModelProperty(value = "配件售价")
    private Integer sellingAmt;

}
