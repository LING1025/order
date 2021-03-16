package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "关键词输入提示地址数据")
public class LocationList implements Serializable {
    @ApiModelProperty(value = "提示文字")
    private String title;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "提示所述位置坐标")
    private List<Location> locations;
}
