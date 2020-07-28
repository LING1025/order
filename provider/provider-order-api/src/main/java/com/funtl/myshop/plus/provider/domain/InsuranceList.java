package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "保险明细上部分数据")
public class InsuranceList implements Serializable {

    @ApiModelProperty(value = "承保险类别")
    private Integer insureType;

    @ApiModelProperty(value = "性质类别")
    private String insureTypeName;

    @ApiModelProperty(value = "座位类别")
    private String insurePercntName;

    @ApiModelProperty(value = "座位数")
    private Integer percnt;

    @ApiModelProperty(value = "产地")
    private String carPlace;

}
