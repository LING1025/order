package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "异常佣金人佣金记录")
public class CommissionRecordList implements Serializable {

    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "佣金人")
    private String pushMan;

    @ApiModelProperty(value = "佣金人电话")
    private String pushTel;

    @ApiModelProperty(value = "佣金金额")
    private Long pushAmt;

    @ApiModelProperty(value = "关系")
    private String pushRelationName;

    @ApiModelProperty(value = "佣金说明")
    private String pushMemo;
}
