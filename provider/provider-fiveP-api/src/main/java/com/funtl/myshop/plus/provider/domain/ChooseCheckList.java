package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "外访报告：签核人员数据")
public class ChooseCheckList implements Serializable {
    @ApiModelProperty(value = "员工账户序号")
    private Long userAuto;

    @ApiModelProperty(value = "部门")
    private String depName;

    @ApiModelProperty(value = "员工姓名")
    private String empName;

    @ApiModelProperty(value = "职级")
    private String titleName;
}
