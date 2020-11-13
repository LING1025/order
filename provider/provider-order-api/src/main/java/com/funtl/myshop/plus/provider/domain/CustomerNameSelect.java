package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "客户名称下拉选数据")
public class CustomerNameSelect implements Serializable {
    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "客户对应的序号")
    private Long tradeItemAuto;
}
