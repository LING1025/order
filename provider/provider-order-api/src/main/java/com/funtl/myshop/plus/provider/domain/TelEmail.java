package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class TelEmail implements Serializable {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String mtel;

    /**
     * 邮箱
     */
    private String email;
}
