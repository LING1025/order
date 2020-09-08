package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class FlowAuditParamDto implements Serializable {
    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto=0L;

    @ApiModelProperty(value = "本人id")
    private Long userAuto=0L;

    @ApiModelProperty(value = "角色id")
    private Integer roles;

    @ApiModelProperty(value = "签核意见")
    private String memo="OK";

    @ApiModelProperty(value = "是否核准 0 否 1 是")
    private Integer isAccess=0;

    @ApiModelProperty(value = "是否加签 0 否 1是")
    private Integer isAdd=0;

    @ApiModelProperty(value = "是否代理 0 否 1是")
    private Integer isAgent=0;

    @ApiModelProperty(value = "是否授信 0 空 1是")
    private String isCredit="";

    @ApiModelProperty(value = "代理人id")
    private Integer agentPerson=0;


}
