package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "外访新增后信息列表")
public class OutList implements Serializable {

    @ApiModelProperty(value = "外访客户表序号")
    private Long outBoundAuto;

    @ApiModelProperty(value = "客户序号")
    private Long tradeItemAuto;

    @ApiModelProperty(value = "状态")
    private String statusName;

    @ApiModelProperty(value = "客户名")
    private String customer;

    @ApiModelProperty(value = "申请人序号")
    private Long userAuto;

    @ApiModelProperty(value = "申请人")
    private String name;
}
