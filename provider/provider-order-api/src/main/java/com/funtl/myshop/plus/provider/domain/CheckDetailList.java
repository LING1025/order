package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "上牌费请款：审核明细")
public class CheckDetailList implements Serializable {
    @ApiModelProperty(value = "审核等级")
    private Integer accessoriesAppSeq;

    @ApiModelProperty(value = "审核人部门")
    private String accessoryAppPersonDept;

    @ApiModelProperty(value = "审核人姓名")
    private String accessoryAppPersonName;

    @ApiModelProperty(value = "签核意见")
    private String accessoryAppstatusD;

    @ApiModelProperty(value = "说明")
    private String accessoryAppMemo;
}
