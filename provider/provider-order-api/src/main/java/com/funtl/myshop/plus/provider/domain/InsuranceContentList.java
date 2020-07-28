package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "保险内容数据")
public class InsuranceContentList implements Serializable {
    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "年度数字")
    private Integer insureYear;

    @ApiModelProperty(value = "年度")
    private String insureYearName;

    @ApiModelProperty(value = "投保")
    private String insureTypeName;

    @ApiModelProperty(value = "保费")
    private BigDecimal insureRealAmt;

    @ApiModelProperty(value = "标准保费")
    private BigDecimal insureAmt;

    @ApiModelProperty(value = "折扣")
    private BigDecimal insureDiscount;

    @ApiModelProperty(value = "押金")
    private Integer insureDpt;

    @ApiModelProperty(value = "备注")
    private String insureMemo;
}
