package com.funtl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Location implements Serializable {
    /**
     * 纬度
     */
    private Double lat;

    /**
     * 经度
     */
    private Double lng;
}
