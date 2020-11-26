package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价：3、车型下拉选")
public class ClasenNameSelect implements Serializable {
    @ApiModelProperty(value = "车型序号")
    private Long clasenAuto;

    @ApiModelProperty(value = "车型名称")
    private String clasenName;
}
