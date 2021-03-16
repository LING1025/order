package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "车辆系统的各种类别数据")
public class CarAreaList implements Serializable {
    @ApiModelProperty(value = "类别名称")
    private String areaName;

    @ApiModelProperty(value = "类别序号")
    private Long areaNum;
}
