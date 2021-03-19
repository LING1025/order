package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "提示所述位置坐标")
public class LatLng implements Serializable {
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double lat;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double lng;
}
