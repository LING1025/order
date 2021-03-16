package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用车审核：更改车辆数据")
public class CarChangeParamDto implements Serializable {
    @ApiModelProperty(value = "登录者userAuto")
    private Long loginUserID;

    @ApiModelProperty(value = "用车申请单号")
    private Long carApplicationAuto;

    @ApiModelProperty(value = "汽车序号")
    private Long carBaseAuto;
}
