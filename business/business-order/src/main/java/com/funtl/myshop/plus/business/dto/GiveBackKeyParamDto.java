package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "车辆归还：归还钥匙数据")
public class GiveBackKeyParamDto implements Serializable {
    @ApiModelProperty(value = "归还钥匙人")
    private Long giveBackUser;

    @ApiModelProperty(value = "钥匙是否归还：0否 1是")
    private Integer isBack;

    @ApiModelProperty(value = "用车申请序号")
    private Long carApplicationAuto;
}
