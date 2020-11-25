package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "回租报价查询按钮所需要的查询参数")
public class LeasebackQueryParam implements Serializable {
    /**
     * 登录者的userAuto
     */
    private Long userAuto;

    /**
     * 1报价单号 2客户名称 3业务员
     */
    private Integer mode;

    /**
     * 查询条件
     */
    private String searchWord;

    /**
     * 开始日期
     */
    private String startDT;

    /**
     * 结束日期
     */
    private String endDT;

    public LeasebackQueryParam(Long userAuto, Integer mode, String searchWord, String startDT, String endDT) {
        this.userAuto = userAuto;
        this.mode = mode;
        this.searchWord = searchWord;
        this.startDT = startDT;
        this.endDT = endDT;
    }
}
