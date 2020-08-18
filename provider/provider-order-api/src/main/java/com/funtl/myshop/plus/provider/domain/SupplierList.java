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
@ApiModel(value = "此报价车商历史成交记录")
public class SupplierList implements Serializable {
    @ApiModelProperty(value = "契约单号")
    private Long orderAuto;

    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "厂牌")
    private String brandName;

    @ApiModelProperty(value = "车型")
    private String clasenName;

    @ApiModelProperty(value = "牌价")
    private BigDecimal listPrice;

    @ApiModelProperty(value = "购入厂商")
    private String supplierName;

    @ApiModelProperty(value = "拨款日期")
    private String bookTime;

    @JsonIgnore
    private Date bookDT;

    @ApiModelProperty(value = "业代")
    private String salesName;

    @JsonIgnore
    private Date endDt;
}
