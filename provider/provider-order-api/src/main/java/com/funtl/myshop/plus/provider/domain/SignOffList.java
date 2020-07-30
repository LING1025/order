package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "签核明细数据")
public class SignOffList implements Serializable {
    @JsonIgnore
    private Long ordersFDetailAuto;
    @JsonIgnore
    private Integer ordersAuto;

    @ApiModelProperty(value = "审核角色")
    private String roleName;

    /**
     * 审核状态
     * 23已审核 审核人：系统自动审核
     * 22核准
     * 21已审核(跨签)
     * 1作废
     * 5驳回
     * 20已审核
     * 0未审核
     */
    @JsonIgnore
    private Integer ordersStatus;

    @ApiModelProperty(value = "审核状态")
    private String ordersStatusName;

    @ApiModelProperty(value = "审核人")
    private String creditPerson;

    @ApiModelProperty(value = "审核意见")
    private String memo;

    @ApiModelProperty(value = "审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
    private Date cdt;

    /**
     * 0空 1代理
     */
    @JsonIgnore
    private Integer isAgent;
}
