package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "车辆归还：累计费用金额数据")
public class RequestAmtParamDto implements Serializable {
    @ApiModelProperty(value = "用车申请序号")
    private Long carApplicationAuto=0L;

    @ApiModelProperty(value = "请款人序号")
    private Long requestUser=0L;

    @ApiModelProperty(value = "累计费用金额")
    private BigDecimal useCarAmt;
}
