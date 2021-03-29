package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "外访客户：客户背景")
public class CusBackground implements Serializable {
    @ApiModelProperty(value = "客户序号")
    private Long tradeItemAuto;

    @ApiModelProperty(value = "客户全称")
    private String fName;

    @ApiModelProperty(value = "身份别序号")
    private Integer idenType;

    @ApiModelProperty(value = "身份别")
    private String idenTypeName;

    @ApiModelProperty(value = "客户性质序号")
    private Integer incType;

    @ApiModelProperty(value = "客户性质")
    private String cusType;

//    @ApiModelProperty(value = "设立时间")
//    private Integer years;
    @ApiModelProperty(value = "设立时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date incCDT;

    @ApiModelProperty(value = "产业代码")
    private String industryCode;

    @ApiModelProperty(value = "产业名称")
    private String industryName;

    @ApiModelProperty(value = "公司注册号")
    private String fId;

    @ApiModelProperty(value = "公司注册地址")
    private String address;
}
