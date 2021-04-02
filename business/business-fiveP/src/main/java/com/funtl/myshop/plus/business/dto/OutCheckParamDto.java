package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "对外访客户明细核准或驳回")
public class OutCheckParamDto implements Serializable {
    @ApiModelProperty(value = "外访签核记录表序号")
    private Long outCheckAuto=0L;

    @ApiModelProperty(value = "外访客户表序号")
    private Long outBoundAuto=0L;

    @ApiModelProperty(value = "登录人UserAuto")
    private Long loginAuto=0L;

    @ApiModelProperty(value = "审核状态:2核准 3驳回")
    private Integer checkStatus;

    @ApiModelProperty(value = "审核意见")
    private String memo;

    @JsonIgnore
    private Long muser;

    @JsonIgnore
    private Date mdt;
}
