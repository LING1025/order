package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "领款人搜索")
public class LKRList implements Serializable {
    @ApiModelProperty(value = "领款人")
    private String name;

    @ApiModelProperty(value = "开户行")
    private String bank;

    @ApiModelProperty(value = "银行别序号")
    private Integer bankType;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "银行名称")
    private String bankNameT;

    @ApiModelProperty(value = "序号")
    private Long totalAuto;
}
