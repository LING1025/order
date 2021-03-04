package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "自动配车、车辆列表查询参数")
public class OrgCarQueryParam implements Serializable {
    /**
     * 动力方式
     */
    private String oilName;

    /**
     * 排挡方式
     */
    private String bsTypeN;

    /**
     * 牌照地区
     */
    private String carArea;

    /**
     * 续航里程
     */
    private BigDecimal mileage;

    /**
     * 1 自动配车 2获取车辆列表
     */
    private Integer type;

    /**
     * 使用人序号
     */
    private Long userAuto;

    /**
     * 用车类别序号：1公务车 2主管用车
     */
    private Integer appType;

    public OrgCarQueryParam(String oilName, String bsTypeN, String carArea, BigDecimal mileage, Integer type, Long userAuto, Integer appType) {
        this.oilName = oilName;
        this.bsTypeN = bsTypeN;
        this.carArea = carArea;
        this.mileage = mileage;
        this.type = type;
        this.userAuto = userAuto;
        this.appType = appType;
    }
}
