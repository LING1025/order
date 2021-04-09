package com.funtl.myshop.plus.provider.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OutQueryParam implements Serializable {
    /**
     * 送件人序号、签核人序号
     */
    private Long loginAuto;

    /**
     * 客户序号
     */
    private Long tradeItemAuto=0L;

    /**
     * 查询类别：1送件人员查看,2签核人员查看
     */
    private Integer type;

    /**
     * 状态
     */
    private String statusName;

    public OutQueryParam(Long loginAuto, Long tradeItemAuto, Integer type, String statusName) {
        this.loginAuto = loginAuto;
        this.tradeItemAuto = tradeItemAuto;
        this.type = type;
        this.statusName = statusName;
    }
}
