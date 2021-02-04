package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用车审核：核准、驳回数据")
public class UseCarCheckParamDto implements Serializable {
    @ApiModelProperty(value = "登录者userAuto")
    private Long loginUserID;

    @ApiModelProperty(value = "用车申请单号")
    private Long carApplicationAuto;

    @ApiModelProperty(value = "核准20、驳回5")
    private Integer appStatus;

    @ApiModelProperty(value = "权限id")
    private Long roleId;

    @ApiModelProperty(value = "审核等级序号")
    private Integer appSeq;

    @ApiModelProperty(value = "签核意见")
    private String memo;
}
