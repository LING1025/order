package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "保险明细表格数据")
public class InsuranceTableList implements Serializable {

    @ApiModelProperty(value = "险种")
    private String insureName;

    @ApiModelProperty(value = "保额")
    private BigDecimal insureLimit;

    @ApiModelProperty(value = "不计免赔")
    private String detailAmtName;

    @ApiModelProperty(value = "标准保费")
    private BigDecimal orgAmt;

    @ApiModelProperty(value = "计价保费")
    private BigDecimal rateAmt;

    @ApiModelProperty(value = "报价单保费")
    private BigDecimal offerAmt;

    @ApiModelProperty(value = "备注")
    private String memo;
}
