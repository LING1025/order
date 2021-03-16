package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "车辆归还：费用列表数据")
public class PurchaseFeeList implements Serializable {

    @ApiModelProperty(value = "请款单号")
    private Long purchaseRequestAuto;

    @ApiModelProperty(value = "用车申请序号")
    private Long carApplicationAuto;

    @ApiModelProperty(value = "费用别")
    private String feeTypeName;

    @ApiModelProperty(value = "请款金额")
    private BigDecimal requestAmt;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

    @ApiModelProperty(value = "请款物品序号")
    private Long purchaseAuto;

    @ApiModelProperty(value = "费用明细")
    private String purchaseRemark;
}
