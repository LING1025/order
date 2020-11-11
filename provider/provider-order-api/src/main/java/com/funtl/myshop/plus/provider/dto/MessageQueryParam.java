package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "讯息列表查询参数")
public class MessageQueryParam implements Serializable {
    /**
     * 0申购单号
     * 1车牌号
     * 2客户名称
     * 6车架号
     * 5上牌完成待请款
     */
    private Integer type;
    private Integer year;
    private Integer month;
    /**
     * 查询条件
     */
    private String searchWord;

    public MessageQueryParam(Integer type, Integer year, Integer month, String searchWord) {
        this.type = type;
        this.year = year;
        this.month = month;
        this.searchWord = searchWord;
    }
}
