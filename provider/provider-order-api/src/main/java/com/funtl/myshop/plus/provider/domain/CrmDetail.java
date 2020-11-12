package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "CRM行程报告具体数据")
public class CrmDetail implements Serializable {
    @ApiModelProperty(value = "报告序号")
    private Long rptVstAuto;

    @ApiModelProperty(value = "拜访时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date vstDT;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "客户来源")
    private String custSourceName;

    @ApiModelProperty(value = "活动内容")
    private String vstTypeName;

    @ApiModelProperty(value = "产生总费用")
    private BigDecimal fee;

    @ApiModelProperty(value = "联系人")
    private String contName;

    @ApiModelProperty(value = "拜访地点")
    private String vstAddr;

    @ApiModelProperty(value = "进度")
    private String outComingName;

    @ApiModelProperty(value = "拜访时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date nextVstDT;

    @ApiModelProperty(value = "达成目标")
    private String aim;

    @ApiModelProperty(value = "拜访内容概述")
    private String summary;

    @ApiModelProperty(value = "详细内容")
    private String detail;

    @ApiModelProperty(value = "收获/感想")
    private String thought;

    @ApiModelProperty(value = "备注")
    private String remark;
}