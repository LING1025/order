package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "试算签核")
public class FlowAuditDto implements Serializable {
    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "本人id")
    private Long userAuto;

    @ApiModelProperty(value = "角色id")
    private Integer roles;

    @ApiModelProperty(value = "签核意见")
    private String memo;

    @ApiModelProperty(value = "是否核准 0 否 1 是")
    private Integer isAccess;

    @ApiModelProperty(value = "是否加签 0 否 1是")
    private Integer isAdd;

    @ApiModelProperty(value = "是否代理 0 否 1是")
    private Integer isAgent;

    @ApiModelProperty(value = "是否授信 0 否 1是")
    private String isCredit;

    @ApiModelProperty(value = "代理人id")
    private Integer agentPerson;
}
