package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "联系人下拉选数据")
public class ContNameSelect implements Serializable {
    @ApiModelProperty(value = "联系人")
    private String contName;

    @ApiModelProperty(value = "联系人对应的序号")
    private Long tradeItemAuto;
}
