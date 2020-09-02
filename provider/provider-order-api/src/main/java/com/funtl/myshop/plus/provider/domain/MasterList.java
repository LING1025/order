package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "主档信息待签核")
public class MasterList implements Serializable {
    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "业务员id")
    private Long salesAuto;

    @ApiModelProperty(value = "业务员")
    private String salesName;

    @ApiModelProperty(value = "所在部门")
    private String depName;

    @ApiModelProperty(value = "承租人")
    private String sName;

    @ApiModelProperty(value = "状态")
    private String orderStatusName;

    @ApiModelProperty(value = "当前流程位置")
    private String nowPlace;

    @ApiModelProperty(value = "一次性租赁")
    private String onetimeName;

    @ApiModelProperty(value = "判断直租与回租，当orderType=8时调用回租接口")
    private Integer orderType;

//    @ApiModelProperty(value = "用于判断签核等按钮的显示")
//    private Integer auditOK;
}
