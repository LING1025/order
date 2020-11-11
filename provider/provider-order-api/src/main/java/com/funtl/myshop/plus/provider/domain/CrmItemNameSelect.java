package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "CRM行程报告：客户来源、活动内容、进度下拉选数据")
public class CrmItemNameSelect implements Serializable {
    @ApiModelProperty(value = "客户来源,活动内容,进度")
    private String itemName;

    @ApiModelProperty(value = "客户来源、活动内容、进度对应的num")
    private Integer num;
}
