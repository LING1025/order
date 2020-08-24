package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemNameList implements Serializable {
    /**
     * 项目名
     */
    private String itemName;
}
