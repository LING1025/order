package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@ApiModel(value = "新增签核数据")
public class SignOffParamDto implements Serializable {
    @ApiModelProperty(value = "签核明细id")
    private Long ordersFDetailAuto = 0L;

    @ApiModelProperty(value = "试算单号")
    private Integer ordersAuto;

    @ApiModelProperty(value = "签核意见")
    private String memo;

    @ApiModelProperty(value = "签核人id")
    private Integer creditPerson;

    @ApiModelProperty(value = "审核状态")
    private Integer ordersStatus;

    @ApiModelProperty(value = "是否代签 0否 1是")
    private Integer isAgent;

    @ApiModelProperty(value = "被代签人id")
    private Integer agentPerson;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;
}
