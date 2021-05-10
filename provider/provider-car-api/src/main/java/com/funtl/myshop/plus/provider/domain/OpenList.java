package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "开户行搜索")
public class OpenList implements Serializable {
    @ApiModelProperty(value = "银行名称")
    private String bankNameT;

    @ApiModelProperty(value = "银行别序号")
    private Integer bankType;

    @ApiModelProperty(value = "开户行名称")
    private String bankName;

    @ApiModelProperty(value = "序号")
    private Long bankDetailAuto;
}
