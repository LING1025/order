package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "CRM行程报告列表数据")
public class CrmTripList implements Serializable {
    @ApiModelProperty(value = "拜访序号")
    private Integer visitAuto;

    @ApiModelProperty(value = "拜访方式")
    private Integer vstType;

    @ApiModelProperty(value = "拜访地点")
    private String vstAddr;

    @ApiModelProperty(value = "拜访时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date vstDT;

    @ApiModelProperty(value = "报告序号")
    private Long rptVstAuto;

    @ApiModelProperty(value = "客户序号")
    private Long tradeItemAuto;
}
