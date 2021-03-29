package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "各种类别名")
public class TypeNameList implements Serializable {
    @ApiModelProperty(value = "序号")
    private Integer num;

    @ApiModelProperty(value = "类别名")
    private String typeName;
}
