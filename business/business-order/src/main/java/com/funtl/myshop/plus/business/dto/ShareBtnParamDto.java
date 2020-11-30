package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "回租报价：分摊表数据")
public class ShareBtnParamDto implements Serializable {
    @ApiModelProperty(value = "租赁期数")
    private Integer mm;

    @ApiModelProperty(value = "贷款成本")
    private BigDecimal rentAmt;

    @ApiModelProperty(value = "印花税")
    private BigDecimal stampTax;

    @ApiModelProperty(value = "年利率(含税)")
    private BigDecimal rateRate;
}
