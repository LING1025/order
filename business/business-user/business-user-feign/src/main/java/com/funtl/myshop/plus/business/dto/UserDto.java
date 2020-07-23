package com.funtl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private Long userAuto;
    private String username;
}
