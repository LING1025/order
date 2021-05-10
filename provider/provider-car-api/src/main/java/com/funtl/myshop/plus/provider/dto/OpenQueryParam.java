package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 开户行查询参数
 */
@Data
public class OpenQueryParam implements Serializable {
    /**
     * 查询类别：1开户行搜索 2选取时获取
     */
    private Integer type;

    /**
     * 开户行名称
     */
    private String bankName;

    /**
     * 选取序号
     */
    private Long bankDetailAuto;

    public OpenQueryParam(Integer type, String bankName, Long bankDetailAuto) {
        this.type = type;
        this.bankName = bankName;
        this.bankDetailAuto = bankDetailAuto;
    }
}
