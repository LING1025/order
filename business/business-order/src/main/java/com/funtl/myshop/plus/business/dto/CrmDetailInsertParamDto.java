package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
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

    @ApiModelProperty(value = "图片1")
    private String img1;

    @ApiModelProperty(value = "图片2")
    private String img2;

    @ApiModelProperty(value = "图片3")
    private String img3;

    @ApiModelProperty(value = "图片4")
    private String img4;

    @ApiModelProperty(value = "图片5")
    private String img5;

    @ApiModelProperty(value = "图片6")
    private String img6;

    @ApiModelProperty(value = "图片7")
    private String img7;

    @ApiModelProperty(value = "图片8")
    private String img8;

    @ApiModelProperty(value = "图片9")
    private String img9;

    @ApiModelProperty(value = "具体地址")
    private String vstRealAddr;

    @ApiModelProperty(value = "拜访日期yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date vstDT;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "客户序号")
    private Long tradeItemAuto;

    @ApiModelProperty(value = "活动内容")
    private String vstTypeName;

    @ApiModelProperty(value = "活动内容序号")
    private Integer vstType;

    @ApiModelProperty(value = "联系人")
    private String contName;

    @ApiModelProperty(value = "拜访地点")
    private String vstAddr;

}
