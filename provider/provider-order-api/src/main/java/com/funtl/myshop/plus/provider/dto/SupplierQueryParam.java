package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价：报价车商列表查询参数")
public class SupplierQueryParam implements Serializable {
    private Integer mode;
    /**
     * 厂商名称
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

    public SupplierQueryParam(Integer mode, String searchWord, Integer pageNum, Integer pageSize, Integer pageIndex) {
        this.mode = mode;
        this.searchWord = searchWord;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }
}
