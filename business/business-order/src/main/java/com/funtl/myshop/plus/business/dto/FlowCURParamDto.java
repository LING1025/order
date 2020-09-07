package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class FlowCURParamDto implements Serializable {
    @ApiModelProperty(value = "0 送签 1 签核  2  读取 3 驳回 4 作废")
    private Integer type;

    /*@ApiModelProperty(value = "0 根据不同的用户读取对应的试算报价单 1 审核判断的信息 2 查询 3 审核明细 流程明细")
    private Integer readType;*/

    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "本人id")
    private Long userAuto;

    @JsonIgnore
    private String rolesName="SALES_ROLES";

    @ApiModelProperty(value = "签核意见")
    private String memo;

    @ApiModelProperty(value = "是否加签 0 否 1是")
    private Integer isAdd;

    @ApiModelProperty(value = "是否核准 0 否 1 是")
    private Integer isAccess;

//    @ApiModelProperty(value = "返回下一阶的审核人ID")
//    private Integer callUserAuto=0;

//    @ApiModelProperty(value = "0 不跨签 1 跨签")
//    private Integer isOverFloor=0;

    @ApiModelProperty(value = "是否代理 0 否 1是")
    private Integer isAgent;

    @ApiModelProperty(value = "是否授信 0 空 1是")
    private String isCredit;

    @ApiModelProperty(value = "代理人id")
    private Integer agentPerson;
}
