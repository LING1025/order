package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用车申请：撤销")
public class RepealApplyDto implements Serializable {
    @ApiModelProperty(value = "用车申请单号")
    private Long carApplicationAuto;

    @ApiModelProperty(value = "登录者userAuto")
    private Long loginUserID;
}
