package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "CRM:行程安排数据")
public class CrmArrangeList implements Serializable {
    @ApiModelProperty(value = "序号")
    private Integer sno;

    @ApiModelProperty(value = "拜访id")
    private Long visitId;

    @ApiModelProperty(value = "拜访序号")
    private Integer visitAuto;

    @ApiModelProperty(value = "客户编号")
    private Integer tradeItemAuto;

    @ApiModelProperty(value = "客户名称")
    private String compName;

    @ApiModelProperty(value = "联系人序号")
    private String contactAuto;

    @ApiModelProperty(value = "联系人姓名")
    private String contName;

    @ApiModelProperty(value = "拜访时间yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date vstDate;

    @ApiModelProperty(value = "活动内容")
    private String vstTypeName;

    @ApiModelProperty(value = "拜访地点")
    private String vstAddr;

    @ApiModelProperty(value = "拜访目的")
    private String vstAim;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否已拜访 0否 1是")
    private Boolean isVsted;

    @ApiModelProperty(value = "创建者")
    private Integer cuser;

    @ApiModelProperty(value = "创建者")
    private String saleName;

    @ApiModelProperty(value = "活动内容序号")
    private Integer vstType;

    @ApiModelProperty(value = "省编码")
    private Long addrProvince;

    @ApiModelProperty(value = "市编码")
    private Long addrCity;

    @ApiModelProperty(value = "区编码")
    private Long addrArea;
}
