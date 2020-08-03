package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@ApiModel(value = "签核数据")
public class SignOffParamDto implements Serializable {
    @ApiModelProperty(value = "签核明细id")
    private Long ordersFDetailAuto = 0L;

    @ApiModelProperty(value = "试算单号")
    private Integer ordersAuto;

    @ApiModelProperty(value = "签核意见")
    private String memo;

    @ApiModelProperty(value = "签核人id(获取用户信息api返回的userAuto)")
    private Integer creditPerson;

    /*@ApiModelProperty(value = "审核状态 如果赋值23则agentPerson、creditPerson赋值0，memo赋值OK" +
            "23系统自动审核" +
            "22核准" +
            "21已审核(跨签)" +
            "1作废" +
            "5驳回" +
            "20已审核" +
            "0未审核")
    private Integer ordersStatus;*/

    /**
     * 是否代签 0否 1是
     */
//    private Integer isAgent;

    @ApiModelProperty(value = "被代签人id(选择操作人：本人/代理人 api返回的selfUser)")
    private Integer agentPerson;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;
}
