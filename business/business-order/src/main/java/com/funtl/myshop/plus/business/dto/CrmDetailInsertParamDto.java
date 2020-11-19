package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "新增CRM行程报告数据")
public class CrmDetailInsertParamDto implements Serializable {
    @ApiModelProperty(value = "拜访编号")
    private Integer visitAuto;

    @ApiModelProperty(value = "实际拜访日期yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date vstDT;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "客户序号")
    private Long tradeItemAuto;

    @ApiModelProperty(value = "客户来源")
    private String custSourceName;

    @ApiModelProperty(value = "客户来源序号")
    private Integer custSource;

    @ApiModelProperty(value = "活动内容")
    private String vstTypeName;

    @ApiModelProperty(value = "活动内容序号")
    private Integer vstType;

    @ApiModelProperty(value = "产生总费用")
    private BigDecimal fee;

    @ApiModelProperty(value = "联系人")
    private String contName;

    @ApiModelProperty(value = "拜访地点")
    private String vstAddr;

    @ApiModelProperty(value = "进度")
    private String outComingName;

    @ApiModelProperty(value = "进度序号")
    private Integer outComing;

    @ApiModelProperty(value = "预计下次拜访日期yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    @ApiModelProperty(value = "业代序号")
    private Integer salesAuto;

    @ApiModelProperty(value = "经度")
    private String signLongitude;

    @ApiModelProperty(value = "纬度")
    private String signLatitude;

    @ApiModelProperty(value = "图片1")
    private String img1;
}
