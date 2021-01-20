package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "经纬度计算距离")
public class Distance implements Serializable {

    @ApiModelProperty(value = "距离单位：公里")
    private Double distance;

//    @ApiModelProperty(value = "用时单位：秒")
//    private Double duration;
}
