package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "拜访地点下拉选数据")
public class AddressList implements Serializable {
    @ApiModelProperty(value = "省、市、区编码")
    private String code;

    @ApiModelProperty(value = "省、市、区名称")
    private String name;
}
