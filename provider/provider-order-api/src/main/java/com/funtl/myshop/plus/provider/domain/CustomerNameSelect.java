package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "客户名称下拉选数据")
public class CustomerNameSelect implements Serializable {
    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "客户对象序号")
    private Long tradeItemAuto;

    @ApiModelProperty(value = "客户序号")
    private Long customerAuto;

    @ApiModelProperty(value = "省编码")
    private Long addrProvince;

    @ApiModelProperty(value = "市编码")
    private Long addrCity;

    @ApiModelProperty(value = "区编码")
    private Long addrArea;

    @ApiModelProperty(value = "街道")
    private String addr;
}
