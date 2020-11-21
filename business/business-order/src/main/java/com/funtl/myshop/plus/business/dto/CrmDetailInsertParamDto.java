package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "CRM:行程记录打卡数据")
public class CrmDetailInsertParamDto implements Serializable {

    @ApiModelProperty(value = "拜访编号")
    private Integer visitAuto;

    @ApiModelProperty(value = "业代序号")
    private Integer salesAuto;

    @ApiModelProperty(value = "经度")
    private String signLongitude;

    @ApiModelProperty(value = "纬度")
    private String signLatitude;

    @ApiModelProperty(value = "图片")
    private String img1;

    @ApiModelProperty(value = "具体地址")
    private String vstRealAddr;

}
