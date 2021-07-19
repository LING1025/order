package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "付款日修改审核：选择操作人")
public class OperatorList implements Serializable {
    @ApiModelProperty(value = "序号")
    private Integer num;

    @ApiModelProperty(value = "操作人序号")
    private Long selfUser;

    @ApiModelProperty(value = "操作人")
    private String selfUserNm;
}
