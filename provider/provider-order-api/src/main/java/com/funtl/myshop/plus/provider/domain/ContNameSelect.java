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

    @ApiModelProperty(value = "联系人对象序号")
    private Long tradeItemAuto;

   /* @ApiModelProperty(value = "联系人序号")
    private Long contactAuto;*/

    @ApiModelProperty(value = "联系人类型编号")
    private Integer contectType;
}
