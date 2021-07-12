package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("客户汇款输入：客户汇款记录")
public class IncomeList implements Serializable {
    @ApiModelProperty(value = "汇款序号")
    private Long bookCarIncomeAuto;

    @ApiModelProperty(value = "授信单号")
    private Long creditMainAuto;

    @ApiModelProperty(value = "项次")
    private Integer seq;

    @ApiModelProperty(value = "汇款类别")
    private String typeQ;

    @ApiModelProperty(value = "汇款人")
    private String incomeUser;

    @ApiModelProperty(value = "汇款账号")
    private String incomeCarNo;

    @ApiModelProperty(value = "进款账号")
    private String incomeAccount;

    @ApiModelProperty(value = "汇款金额")
    private BigDecimal amt;

    @ApiModelProperty(value = "入4S店金额")
    private BigDecimal enter4sAmt;

    @ApiModelProperty(value = "汇款日期")
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date incomeDT;

    @ApiModelProperty(value = "入账金额")
    private BigDecimal realIncomeAmt;

    @ApiModelProperty(value = "入账日期")
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date realIncomeDT;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "公司名称")
    private String incName;

//    @ApiModelProperty(value = "汇款笔数")
//    private Integer rows;
//
//    @ApiModelProperty(value = "总汇款金额")
//    private BigDecimal totalAmt;
}
