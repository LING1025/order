package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "行程报告审核明细数据")
public class TripDetailList implements Serializable {
    @ApiModelProperty(value = "签核人")
    private String fName;

    @ApiModelProperty(value = "签核内容")
    private String memo;

    @ApiModelProperty(value = "签核时间")
    private Date mDT;
}
