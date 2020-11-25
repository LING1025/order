package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "CRM:行程报告提交数据")
public class CrmDetailParamDto implements Serializable {
    @ApiModelProperty(value = "报告序号")
    private Long rptVstAuto=0L;

    @ApiModelProperty(value = "产生总费用")
    private BigDecimal fee;

    @ApiModelProperty(value = "进度")
    private String outComingName;

    @ApiModelProperty(value = "进度序号")
    private Integer outComing;

    @ApiModelProperty(value = "预计下次拜访日期yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
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

    @ApiModelProperty(value = "客户来源")
    private String custSourceName;

    @ApiModelProperty(value = "客户来源序号")
    private Integer custSource;
}
