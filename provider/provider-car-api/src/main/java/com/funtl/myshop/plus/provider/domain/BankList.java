package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "银行类别下拉选")
public class BankList implements Serializable {
    @ApiModelProperty(value = "银行别")
    private Integer bankType;

    @ApiModelProperty(value = "银行名称")
    private String bankNameT;
}
