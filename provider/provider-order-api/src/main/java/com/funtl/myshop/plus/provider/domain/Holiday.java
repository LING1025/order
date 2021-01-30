package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel(value = "判断是否假日用车、计算用车时间")
public class Holiday implements Serializable {

    @ApiModelProperty(value = "是否假日用车：0否 1是")
    private Integer isHoliday;

    /**
     * 是否假日天数大于0
     */
    @JsonIgnore
    private Integer num;

    /**
     * 使用分钟
     */
    @JsonIgnore
    private Integer useCarM;

    @ApiModelProperty(value = "用车时间:单位小时")
    private BigDecimal useCarTime;
}
