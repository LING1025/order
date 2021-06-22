package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "拨款申请作业：车款暂借明细")
public class CarZjList implements Serializable {
    @ApiModelProperty(value = "项次")
    private Integer seq;

    @ApiModelProperty(value = "车款暂借序号")
    private Long zanJieAuto;

    @ApiModelProperty(value = "定金金额")
    private BigDecimal depositAmt;

    @ApiModelProperty(value = "暂借金额")
    private BigDecimal zJAmt;

    @ApiModelProperty(value = "试算金额")
    private BigDecimal orderAmt;

    @ApiModelProperty(value = "厂商名称")
    private String payeeName;

    @ApiModelProperty(value = "收款人账号")
    private String payeeAccount;

    @ApiModelProperty(value = "开户银行")
    private String payeeBank;

    @ApiModelProperty(value = "预计偿还日")
    private String yJRequestDT2;

    @ApiModelProperty(value = "暂借类别序号")
    private Integer zjType;

    @ApiModelProperty(value = "暂借类别")
    private String zjTypeName;

    @ApiModelProperty(value = "费用别序号")
    private Integer feeTypeAuto;

    @ApiModelProperty(value = "费用别")
    private String feeTypeAutoN;

    @ApiModelProperty(value = "银行别序号")
    private Integer bankType;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "暂借来源")
    private String dataFrom;
}
