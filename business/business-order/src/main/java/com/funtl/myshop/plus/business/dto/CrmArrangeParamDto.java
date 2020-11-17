package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "CRM:行程安排数据")
public class CrmArrangeParamDto implements Serializable {
    @ApiModelProperty(value = "拜访编号")
    private Integer visitAuto;

    @ApiModelProperty(value = "是否已拜访 0否 1是")
    private Boolean isVsted;

    @ApiModelProperty(value = "业代序号")
    private Integer salesAuto;

    @ApiModelProperty(value = "业代名称")
    private String saleName;

    @ApiModelProperty(value = "拜访时间yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date vstDate;

    @ApiModelProperty(value = "活动内容")
    private Integer vstType;

    @ApiModelProperty(value = "活动内容")
    private String vstTypeName;

    @ApiModelProperty(value = "客户对象序号")
    private Integer tradeItemAuto;

    @ApiModelProperty(value = "客户序号")
    private String customerAuto;

    @ApiModelProperty(value = "拜访客户名称")
    private String customerName;

    @ApiModelProperty(value = "联系人类型编号")
    private Integer contectType;

    @ApiModelProperty(value = "联系人姓名")
    private String contName;

    @ApiModelProperty(value = "拜访地点")
    private String vstAddr;

    @ApiModelProperty(value = "省编码")
    private Long addrProvince;

    @ApiModelProperty(value = "市编码")
    private Long addrCity;

    @ApiModelProperty(value = "区编码")
    private Long addrArea;

    @ApiModelProperty(value = "拜访省")
    private String vstProvince;

    @ApiModelProperty(value = "拜访市")
    private String vstCity;

    @ApiModelProperty(value = "拜访区")
    private String vstArea;

    @ApiModelProperty(value = "拜访目的")
    private String vstAim;

    @ApiModelProperty(value = "内容备注")
    private String remark;

    @JsonIgnore
    private Date cdt;

}
