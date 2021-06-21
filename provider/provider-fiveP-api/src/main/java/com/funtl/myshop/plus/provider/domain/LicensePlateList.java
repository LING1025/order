package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "拨款申请作业：出保单地下拉选")
public class LicensePlateList implements Serializable {
    @ApiModelProperty(value = "出保单地序号")
    private Integer insureAddr;

    @ApiModelProperty(value = "出保单地")
    private String insureAddrN;
}
