package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "公司别下拉选")
public class IncNameList implements Serializable {
    @ApiModelProperty(value = "公司序号")
    private Long incAuto;

    @ApiModelProperty(value = "公司名称")
    private String incName;
}
