package com.funtl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LocationList implements Serializable {
    private String address;
    private List<Location> list;
}
