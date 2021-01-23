package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用车类别、牌照地区数据")
public class CarAreaList implements Serializable {
    @ApiModelProperty(value = "用车类别、牌照地区名")
    private String areaName;

    @ApiModelProperty(value = "用车类别、牌照地区序号")
    private Long areaNum;
}
