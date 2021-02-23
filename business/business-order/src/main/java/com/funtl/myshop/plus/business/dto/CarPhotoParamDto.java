package com.funtl.myshop.plus.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "车辆归还：实时拍照数据")
public class CarPhotoParamDto implements Serializable {

    @ApiModelProperty(value = "仪表盘起始里程图片")
    private String startImg;

    @ApiModelProperty(value = "仪表盘归还里程图片")
    private String endImg;

    @ApiModelProperty(value = "车身照左侧")
    private String leftImg;

    @ApiModelProperty(value = "车身照右侧")
    private String rightImg;

    @ApiModelProperty(value = "车身照后部")
    private String behindImg;

    @ApiModelProperty(value = "起始里程拍照时间")
    private Date time1;

    @ApiModelProperty(value = "归还里程拍照时间")
    private Date time2;

    @ApiModelProperty(value = "车身左侧拍照时间")
    private Date time3;

    @ApiModelProperty(value = "车身右侧拍照时间")
    private Date time4;

    @ApiModelProperty(value = "车身后部拍照时间")
    private Date time5;

    @ApiModelProperty(value = "起始里程拍照地址")
    private String address1;

    @ApiModelProperty(value = "归还里程拍照地址")
    private String address2;

    @ApiModelProperty(value = "车身左侧拍照地址")
    private String address3;

    @ApiModelProperty(value = "车身右侧拍照地址")
    private String address4;

    @ApiModelProperty(value = "车身后部拍照地址")
    private String address5;
}
