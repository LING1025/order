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
    private Long tradeItemAuto;

    /**
     * 查询类别：1送件人员查看,2签核人员查看
     */
    private Integer type;
}
