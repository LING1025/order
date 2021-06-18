package com.funtl.myshop.plus.provider.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户汇款输入：新增汇款
 */
@Data
@ApiModel(value = "客户汇款输入：新增、修改汇款数据")
public class IncomeInsertDto implements Serializable {
    @ApiModelProperty(value = "1新增汇款 2修改汇款")
    private Integer kindType;

    @ApiModelProperty(value = "汇款序号")
    private Long bookCarIncomeAuto;

    @ApiModelProperty(value = "登录人userAuto")
    private Long loginUserId;

    @ApiModelProperty(value = "授信单号")
    private Long creditMainAuto=0L;

    @ApiModelProperty(value = "进款公司别序号")
    private Long incAuto=0L;

    @ApiModelProperty(value = "进款公司别")
    private String incName;

    @ApiModelProperty(value = "汇款账号")
    private String incomeCarNo;

    @ApiModelProperty(value = "进款账号")
    private String incomeAccount="";

    @ApiModelProperty(value = "汇款类别序号")
    private Integer type;

    @ApiModelProperty(value = "汇款类别")
    private String typeName;

    @ApiModelProperty(value = "汇款金额")
    private BigDecimal amt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "汇款人")
    private String incomeUser;

    @ApiModelProperty(value = "入4S店金额")
    private BigDecimal enter4sAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "汇款日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date incomeDT;

    @ApiModelProperty(value = "入账金额（新增汇款时不用填）")
    private BigDecimal realIncomeAmt;

    @ApiModelProperty(value = "入账日期（新增汇款时不用填）")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date realIncomeDT;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "保证金")
    private BigDecimal dptAmt;
}
