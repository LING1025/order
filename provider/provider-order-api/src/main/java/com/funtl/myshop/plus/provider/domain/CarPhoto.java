package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆归还：实时拍照数据
 */
@Data
public class CarPhoto implements Serializable {
    /**
     * 仪表盘起始里程图片
     */
    private String startImg;

    /**
     * 仪表盘归还里程图片
     */
    private String endImg;

    /**
     * 车身照左侧
     */
    private String leftImg;

    /**
     * 车身照右侧
     */
    private String rightImg;

    /**
     * 车身照后部
     */
    private String behindImg;

    /**
     * 起始里程拍照时间
     */
    private Date time1;

    /**
     * 归还里程拍照时间
     */
    private Date time2;

    /**
     * 车身左侧拍照时间
     */
    private Date time3;

    /**
     * 车身右侧拍照时间
     */
    private Date time4;

    /**
     * 车身后部拍照时间
     */
    private Date time5;

    /**
     * 起始里程拍照地址
     */
    private String address1;

    /**
     * 归还里程拍照地址
     */
    private String address2;

    /**
     * 车身左侧拍照地址
     */
    private String address3;

    /**
     * 车身右侧拍照地址
     */
    private String address4;

    /**
     * 车身后部拍照地址
     */
    private String address5;
}
