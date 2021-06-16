package com.funtl.myshop.plus.provider.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.funtl.myshop.plus.provider.domain.IncomeList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("客户汇款输入：客户汇款记录")
public class IncomeDto implements Serializable {
    @ApiModelProperty(value = "客户汇款记录列表")
    private List<IncomeList> incomeListList;

    @ApiModelProperty(value = "汇款笔数")
    private Integer rows;

    @ApiModelProperty(value = "总汇款金额")
    private BigDecimal totalAmt;
}
