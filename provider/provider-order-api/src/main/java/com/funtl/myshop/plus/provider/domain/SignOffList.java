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
    @ApiModelProperty(value = "审核角色id")
    private Integer roleId;

    @ApiModelProperty(value = "审核角色")
    private String roleName;

    @ApiModelProperty(value = "审核状态")
    private String orderStatusName;

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
