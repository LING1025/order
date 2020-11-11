package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "CRM行程报告：客户名称、联系人下拉选数据")
public class CrmSelect implements Serializable {
    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "联系人")
    private String contName;

    @ApiModelProperty(value = "客户、联系人对应的序号")
    private Long tradeItemAuto;
}
