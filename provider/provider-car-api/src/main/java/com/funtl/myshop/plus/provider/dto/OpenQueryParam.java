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
     * 开户行序号
     */
    private Long bankDetailAuto;

    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 条数
     */
    private Integer pageSize;

    /**
     * 当前要求的页码索引
     */
    private Integer pageIndex;

    public OpenQueryParam(Integer type, String bankName, Long bankDetailAuto, Integer pageNum, Integer pageSize, Integer pageIndex) {
        this.type = type;
        this.bankName = bankName;
        this.bankDetailAuto = bankDetailAuto;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }
}
