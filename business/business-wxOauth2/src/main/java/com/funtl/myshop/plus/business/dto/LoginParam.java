package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * 登录参数
 */

@Data
public class LoginParam implements Serializable {
    private String openId;

    @JsonIgnore
    private String password = "2020+0710";
}
