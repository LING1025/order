package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "经纬度转地址数据")
public class GetLocation implements Serializable {
    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "国籍")
    private String nation;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "省份代码")
    private String provinceCode;

    @ApiModelProperty(value = "城市代码")
    private String cityCode;

    @ApiModelProperty(value = "国家代码")
    private String nationCode;
}
