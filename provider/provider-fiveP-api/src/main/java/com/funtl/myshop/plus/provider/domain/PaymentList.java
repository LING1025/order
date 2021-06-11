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
    private Long BookCar_Auto;

    @ApiModelProperty(value = "请购状态")
    private String BookCarStatus_D;

    @ApiModelProperty(value = "授信单号")
    private Long CreditMain_Auto;

    @ApiModelProperty(value = "客戶名称")
    private String FName;

    @ApiModelProperty(value = "厂牌")
    private String BrandName;

    @ApiModelProperty(value = "车型")
    private String ClasenName;

    @ApiModelProperty(value = "型号")
    private String ClasenCode;

    @ApiModelProperty(value = "车色")
    private String CarColor;

    @ApiModelProperty(value = "牌价")
    private BigDecimal ListPrice;

    @ApiModelProperty(value = "进价")
    private BigDecimal GetPrice;

    @ApiModelProperty(value = "单位")
    private String DepName;

    @ApiModelProperty(value = "业代")
    private String SalesT;
}
