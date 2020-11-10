package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "行程报告审核数据")
public class ClientCheckParamDto implements Serializable {
    @ApiModelProperty(value = "行程列表序号")
    private Long rptVstFlowAuto;

    @ApiModelProperty(value = "审核意见")
    private String memo;

    @ApiModelProperty(name = "操作人序号")
    private Integer userAuto;

    @ApiModelProperty(value = "是否是代理 0 否 1是")
    private Integer isAgent;
}
