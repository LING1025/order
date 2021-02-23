package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "车辆领取：领取钥匙数据")
public class GetKeyParamDto implements Serializable {
    @ApiModelProperty(value = "领取钥匙人")
    private Long getKeyUser;

    @ApiModelProperty(value = "是否领取钥匙 ：0否 1是")
    private Integer isGet;

    @ApiModelProperty(value = "用车申请序号")
    private Long carApplicationAuto;
}
