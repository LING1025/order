package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用车请款物品信息
 */
@Data
public class CarFeeRequest implements Serializable {
    @ApiModelProperty(value = "请款人账号")
    private Long requestUser;

    /**
     * 请款单号
     */
    @JsonIgnore
    private Long rrAuto;

    /**
     * 物品名称
     */
    @JsonIgnore
    private String purchaseName;

    /**
     * 请款物品对应的请购单号
     */
    @JsonIgnore
    private Long purchaseRequisitionAuto=0L;

    /**
     * 请购请款类别(0:请购1:请款)
     */
    @JsonIgnore
    private Integer type=1;

    /**
     * 单价
     */
    @JsonIgnore
    private BigDecimal purchasePrice;

    /**
     * 数量
     */
    @JsonIgnore
    private Integer purchaseAmount=1;

    /**
     * 备注
     */
    @ApiModelProperty(value = "费用明细")
    private String purchaseRemark;

    /**
     * 单个物品总额
     */
    @JsonIgnore
    private BigDecimal purchaseTotalAmt;

    /**
     * 创建人
     */
    @JsonIgnore
    private Long cuser=requestUser;

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date cdt=new Date();

    /**
     * 使用部门
     */
    @JsonIgnore
    private Long useDep;

    @ApiModelProperty(value = "费用别")
    private Integer feeType;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "费用时间")
    private Date feeTime;

    @ApiModelProperty(value = "附件图片")
    private String img;
}
