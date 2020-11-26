package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价：总厂牌下拉选")
public class FactoryBrandNameSelect implements Serializable {
    @ApiModelProperty(value = "总厂牌序号")
    private Long factoryBrandAuto;

    @ApiModelProperty(value = "总厂牌名称")
    private String factoryBrandName;
}
