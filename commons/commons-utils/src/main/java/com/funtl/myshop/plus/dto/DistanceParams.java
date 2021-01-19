package com.funtl.myshop.plus.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DistanceParams implements Serializable {
    /**
     *计算方式，取值：
     * driving：驾车
     * walking：步行
     * bicycling：自行车
     */
    private String mode;

    /**
     *起点坐标
     * 例1：
     * from=39.071510,117.190091
     * 例2
     * from=39.071510,117.190091,270;39.108951,117.279396,180
     */
    private String from;

    /**
     *终点坐标
     * to=39.071510,117.190091;40.007632,116.389160
     */
    private String to;

    /**
     *开发密钥（Key）
     */
    private String key;
}
