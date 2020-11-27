package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价：客户全称列表查询参数")
public class FNamesQueryParam implements Serializable {
    /**
     * 业代序号
     */
    private Long salesAuto;

    /**
     * 客户别
     */
    private String searchWord;

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

    public FNamesQueryParam(Long salesAuto, String searchWord, Integer pageNum, Integer pageSize, Integer pageIndex) {
        this.salesAuto = salesAuto;
        this.searchWord = searchWord;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }
}
