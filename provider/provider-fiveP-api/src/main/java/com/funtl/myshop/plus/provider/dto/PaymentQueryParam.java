package com.funtl.myshop.plus.provider.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "客户汇款输入：查询参数")
public class PaymentQueryParam implements Serializable {
    /**
     * 此处默认2
     */
    @JsonIgnore
    private Integer typeQ;

    @ApiModelProperty(value = "查询类别：1授信单号 2客户名称 3业代 4请购单号")
    private Integer type;

    @ApiModelProperty(value = "输入要查询的内容")
    private String searchWord;

    @ApiModelProperty(value = "登录人userAuto")
    private Long userAuto;

    /**
     * 存储过程并未引用，先留着
     */
    @JsonIgnore
    private String depName;

    /**
     * 存储过程并未引用，先留着
     */
    @JsonIgnore
    private Long ordersAuto;

    public PaymentQueryParam(Integer typeQ, Integer type, String searchWord, Long userAuto, String depName, Long ordersAuto) {
        this.typeQ = typeQ;
        this.type = type;
        this.searchWord = searchWord;
        this.userAuto = userAuto;
        this.depName = depName;
        this.ordersAuto = ordersAuto;
    }
}
