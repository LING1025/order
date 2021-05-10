package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 领款人查询参数
 */
@Data
public class LKRQueryParam implements Serializable {
    /**
     * 查询类别：1领款人名称搜索 2选取时获取
     */
    private Integer type;

    /**
     * 领款人
     */
    private String name;

    /**
     * 领款序号
     */
    private Long totalAuto;

    public LKRQueryParam(Integer type, String name, Long totalAuto) {
        this.type = type;
        this.name = name;
        this.totalAuto = totalAuto;
    }
}
