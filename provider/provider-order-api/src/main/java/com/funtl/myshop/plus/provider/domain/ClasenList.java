package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "此报价车型历史成交记录")
public class ClasenList implements Serializable {
    @ApiModelProperty(value = "契约单号")
    private Long orderAuto;

    @ApiModelProperty(value = "牌价")
    private BigDecimal listPrice;

    @ApiModelProperty(value = "折价")
    private BigDecimal disPrice;

    @ApiModelProperty(value = "进价")
    private BigDecimal getPrice;

    @ApiModelProperty(value = "实际折率")
    private String realRate;

    @ApiModelProperty(value = "购入厂商")
    private String supplierName;

    @ApiModelProperty(value = "领照日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date makeDT;

    @ApiModelProperty(value = "业代")
    private String salesName;

    @JsonIgnore
    private Date startDT;
}
