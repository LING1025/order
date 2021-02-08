package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "车辆安排：发放钥匙数据")
public class GiveKeyDto implements Serializable {
    @ApiModelProperty(value = "发放钥匙人")
    private Long giveKeyUser;

    @ApiModelProperty(value = "是否发放钥匙 ：0否 1是")
    private Integer isGive;

    @ApiModelProperty(value = "用车申请序号")
    private Long carApplicationAuto;
}
