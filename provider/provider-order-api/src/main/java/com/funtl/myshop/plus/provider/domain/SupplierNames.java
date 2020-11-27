package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价：报价车商列表")
public class SupplierNames implements Serializable {
    @ApiModelProperty(value = "厂商编号")
    private Long supplierBuy;

    @ApiModelProperty(value = "厂商名称")
    private String supplierBuyName;

    @ApiModelProperty(value = "状态")
    private String isOpen;
}
