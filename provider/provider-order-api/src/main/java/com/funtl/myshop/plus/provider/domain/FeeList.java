package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "上牌规费明细数据")
public class FeeList implements Serializable {
    @ApiModelProperty(value = "公司别")
    private String incName;

    @ApiModelProperty(value = "费用别")
    private String feeTypeName;

    @ApiModelProperty(value = "费用金额")
    private BigDecimal feeAmt;

    @ApiModelProperty(value = "备注")
    private String memo;
}
