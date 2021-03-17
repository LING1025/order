package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "经纬度转地址数据")
public class GetLocation implements Serializable {

    @ApiModelProperty(value = "地址")
    private String address;
}
