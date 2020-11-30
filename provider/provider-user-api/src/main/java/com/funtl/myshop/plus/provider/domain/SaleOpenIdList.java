package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "小程序已授权用户数据")
public class SaleOpenIdList implements Serializable {
    @ApiModelProperty(value = "业代序号")
    private Long salesAuto;

    @ApiModelProperty(value = "业代姓名")
    private String saleName;

    @ApiModelProperty(value = "业代对应的openId")
    private String openId;
}
