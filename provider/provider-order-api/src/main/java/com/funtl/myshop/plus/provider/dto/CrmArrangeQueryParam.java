package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "CRM:行程安排查询参数")
public class CrmArrangeQueryParam implements Serializable {
    /**
     * 1客户名称 2联系人姓名
     */
    private Integer kind;

    /**
     * 查询条件
     */
    private String searchWord;

    /**
     * 业代序号
     */
    private String salesName;

    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 条数
     */
    private Integer pageSize;

    public CrmArrangeQueryParam(Integer kind, String searchWord, String salesName, Integer pageNum, Integer pageSize) {
        this.kind = kind;
        this.searchWord = searchWord;
        this.salesName = salesName;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
