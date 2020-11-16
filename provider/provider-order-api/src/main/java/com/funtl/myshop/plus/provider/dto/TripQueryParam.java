package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "行程报告记录的查询参数")
public class TripQueryParam implements Serializable {
    /**
     * 年份
     */
    private Integer year;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 状态 0 未审核 1 已审核
     */
    private Integer status;

    /**
     * 操作人序号
     */
    private Integer userAuto;

    /**
     * 权限序号
     */
    private Integer roleAuto;

    /**
     * 部门序号
     */
    private Integer orgAuto;

    public TripQueryParam(Integer year, Integer month, Integer status, Integer userAuto, Integer roleAuto, Integer orgAuto) {
        this.year = year;
        this.month = month;
        this.status = status;
        this.userAuto = userAuto;
        this.roleAuto = roleAuto;
        this.orgAuto = orgAuto;
    }
}
