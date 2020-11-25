package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "CRM:行程记录打卡数据")
public class CrmDetailInsertParamDto implements Serializable {
    @ApiModelProperty(value = "拜访id")
    private Long visitId=0L;

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

    @ApiModelProperty(value = "拜访日期yyyy-MM-dd")
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

    @ApiModelProperty(value = "联系人")
    private String contName;

    @ApiModelProperty(value = "拜访地点")
    private String vstAddr;

}
