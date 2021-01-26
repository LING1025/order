package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "用车申请：签核明细")
public class UseCarDoc implements Serializable {
//    @ApiModelProperty(value = "出车申请单号")
//    private Long carApplicationAuto;

    @ApiModelProperty(value = "审核角色")
    private String roleName;

//    @ApiModelProperty(value = "序号")
//    private Integer appSeq;

    @ApiModelProperty(value = "审核意见")
    private String memo;

    @ApiModelProperty(value = "审核人员")
    private String checkName;

//    @ApiModelProperty(value = "审核状态")
//    private String statusN;

//    @ApiModelProperty(value = "申请时间")
//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
//    private Date cdt;

    @ApiModelProperty(value = "审核时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date mdt;

//    @ApiModelProperty(value = "申请人")
//    private String appUserN;
}
