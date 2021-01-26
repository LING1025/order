package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String appUserN;

    @ApiModelProperty(value = "使用人")
    private String username;

    @ApiModelProperty(value = "申请时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date cdt;

    @ApiModelProperty(value = "使用时间：开始时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date planStartDT;

    @ApiModelProperty(value = "使用时间：结束时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date planEndDT;

    @ApiModelProperty(value = "用车类别：1公务车 2主管用车")
    private String appTypeN;

    @ApiModelProperty(value = "车辆号码")
    private String makNo;

    @ApiModelProperty(value = "状态")
    private String statusN;
}
