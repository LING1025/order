package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "付款条件中的表")
public class StepwiseList implements Serializable {

    @ApiModelProperty(value = "开始期数")
    private Integer mmS;

    @ApiModelProperty(value = "结束期数")
    private Integer mmE;

    @ApiModelProperty(value = "月租金")
    private BigDecimal stepwiseMAmt;
}
