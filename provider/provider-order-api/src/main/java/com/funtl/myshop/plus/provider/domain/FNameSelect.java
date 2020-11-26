package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价：2、承办业代姓名下拉选")
public class FNameSelect implements Serializable {
    @ApiModelProperty(value = "业代序号")
    private Long userAuto;

    @ApiModelProperty(value = "业代姓名")
    private String fName;
}
