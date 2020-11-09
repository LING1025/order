package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "行程报告记录数据")
public class TripRecorderList implements Serializable {
    @ApiModelProperty(value = "行程单号")
    private Long rptVstAuto;

    @ApiModelProperty(value = "行程列表序号")
    private Long rptVstFlowAuto;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "联系人")
    private String contName;

    @ApiModelProperty(value = "拜访地点")
    private String vstAddr;

    @ApiModelProperty(value = "活动内容")
    private String vstTypeName;

    @ApiModelProperty(value = "进度")
    private String outComingName;

    @ApiModelProperty(value = "拜访日")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date vstDT;

    @ApiModelProperty(value = "详细内容")
    private String detail;

    @ApiModelProperty(value = "业务员")
    private String salesName;

    @ApiModelProperty(value = "状态")
    private String statusName;
}
