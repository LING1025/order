package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "客户汇款输入：查询按钮返回列表数据")
public class PaymentList implements Serializable {
    @ApiModelProperty(value = "请购单号")
    private Long bookCarAuto;

    @ApiModelProperty(value = "请购状态")
    private String bookCarStatusD;

    @ApiModelProperty(value = "授信单号")
    private Long creditMainAuto;

    @ApiModelProperty(value = "客戶名称")
    private String cusName;

    @ApiModelProperty(value = "厂牌")
    private String brandName;

    @ApiModelProperty(value = "车型")
    private String clasenName;

    @ApiModelProperty(value = "型号")
    private String clasenCode;

    @ApiModelProperty(value = "车色")
    private String carColor;

    @ApiModelProperty(value = "牌价")
    private String listPrice;

    @ApiModelProperty(value = "进价")
    private String getPrice;

    @ApiModelProperty(value = "单位")
    private String depName;

    @ApiModelProperty(value = "业代")
    private String salesT;
}
