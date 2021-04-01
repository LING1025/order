package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "外访签核记录数据")
public class OutInfoCheck implements Serializable {
    @ApiModelProperty(value = "外访签核记录表序号")
    private Long outCheckAuto;

    @ApiModelProperty(value = "外访客户表序号")
    private Long outBoundAuto;

    @ApiModelProperty(value = "审核人")
    private String checkName;

    @ApiModelProperty(value = "审核时间yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date checkDT;

    @ApiModelProperty(value = "审核状态")
    private String statusName;

    @ApiModelProperty(value = "审核意见")
    private String memo;

    @ApiModelProperty(value = "申请人")
    private String name;

    @ApiModelProperty(value = "申请时间yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date cdt;
}
