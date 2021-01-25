package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "用车申请：申请列表数据")
public class UserCarList implements Serializable {
    @ApiModelProperty(value = "出车申请单号")
    private Long carApplicationAuto;

    @ApiModelProperty(value = "申请人")
    private Integer appUser;

    @ApiModelProperty(value = "使用人")
    private String username;

    @ApiModelProperty(value = "申请时间")
    private Date appDT;

    @ApiModelProperty(value = "使用时间：开始时间")
    private Date planStartDT;

    @ApiModelProperty(value = "使用时间：结束时间")
    private Date planEndDT;

    @ApiModelProperty(value = "用车类别：1公务车 2主管用车")
    private Integer appType;

    @ApiModelProperty(value = "车辆号码")
    private String makNo;

    @ApiModelProperty(value = "状态")
    private String statusN;
}
