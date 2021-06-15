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
    private Integer TypeQ=2;

    @ApiModelProperty(value = "查询类别：1授信单号 2客户名称 3业代 4请购单号")
    private Integer Type;

    @ApiModelProperty(value = "输入要查询的内容")
    private String SearchWord;

    @ApiModelProperty(value = "登录人userAuto")
    private Long UserAuto;

    /**
     * 存储过程并未引用，先留着
     */
    @JsonIgnore
    private String DepName;

    /**
     * 存储过程并未引用，先留着
     */
    @JsonIgnore
    private Long Orders_Auto;

    public PaymentQueryParam(Integer typeQ, Integer type, String searchWord, Long userAuto, String depName, Long orders_Auto) {
        TypeQ = typeQ;
        Type = type;
        SearchWord = searchWord;
        UserAuto = userAuto;
        DepName = depName;
        Orders_Auto = orders_Auto;
    }
}
