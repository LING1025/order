package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "回租报价查询按钮返回数据")
public class LeasebackList implements Serializable {
    @ApiModelProperty(value = "公司别")
    private String incName;

    @ApiModelProperty(value = "单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "客户名称")
    private String custName;

    @ApiModelProperty(value = "厂牌")
    private String brandName;

    @ApiModelProperty(value = "车型")
    private String clasenName;

    @ApiModelProperty(value = "月租金")
    private BigDecimal mAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "残值")
    private BigDecimal overAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "保证金")
    private BigDecimal dptAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "成交利率")
    private BigDecimal rentRate = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "业务员")
    private String salesName;

    @ApiModelProperty(value = "状态")
    private String statusName;
}
