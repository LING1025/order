package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价：2、厂牌下拉选")
public class BrandNameSelect implements Serializable {
    @ApiModelProperty(value = "厂牌序号")
    private Long brandAuto;

    @ApiModelProperty(value = "厂牌名称")
    private String brandName;
}
