package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "其他費用明細数据")
public class BudgetList implements Serializable {
    @ApiModelProperty(value = "内容")
    private String budgetName;

    @ApiModelProperty(value = "费用金额")
    private BigDecimal pa;

    @ApiModelProperty(value = "费用次数")
    private BigDecimal pb;

    @ApiModelProperty(value = "成本费用")
    private BigDecimal rateAmt;

    @ApiModelProperty(value = "成本月租金")
    private BigDecimal rateMAmt;

    @ApiModelProperty(value = "计价费用")
    private BigDecimal finalAmt;

    @ApiModelProperty(value = "计价月租金")
    private BigDecimal finalMAmt;

    @ApiModelProperty(value = "备注")
    private String memo;

    @ApiModelProperty(value = "用于直租租金计算判断ratel04A、l04A、fl04A的值")
    private Integer typeAuto;
}
