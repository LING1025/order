package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "业代下拉选数据")
public class SaleNameSelect implements Serializable {
    @ApiModelProperty(value = "业代序号")
    private Long salesAuto;

    @ApiModelProperty(value = "业代名称")
    private String saleName;
}
