package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "代理人数据")
public class AgentList implements Serializable {
    /**
     * 本人id（被代理）
     */
    @ApiModelProperty(value = "代理人id")
    private Long selfUser;

    @ApiModelProperty(value = "选择代理人")
    private String selfName;

}
