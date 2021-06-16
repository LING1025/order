package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "客户汇款输入：进款账号")
public class AccountNameList implements Serializable {
    @ApiModelProperty(value = "序号")
    private Long accountAuto;

    @ApiModelProperty(value = "进款账号")
    private String accountName;
}
