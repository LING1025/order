package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "回租报价：分摊表下载数据")
public class ShareBtn implements Serializable {
    @ApiModelProperty(value = "本金")
    private BigDecimal capital;

    @ApiModelProperty(value = "月租金")
    private BigDecimal monthRent;

    @ApiModelProperty(value = "摊还利息")
    private BigDecimal amortization;

    @ApiModelProperty(value = "利息税额")
    private BigDecimal tax;

    @ApiModelProperty(value = "摊还本金")
    private BigDecimal amortizeAmt;

    @ApiModelProperty(value = "本金余额")
    private BigDecimal balance;
}
