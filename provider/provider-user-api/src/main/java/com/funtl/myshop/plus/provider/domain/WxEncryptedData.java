package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "[WxEncryptedData]")
public class WxEncryptedData implements Serializable {
    private Long id;

    private String openId;

    private String nickName;

    private String gender;

    private String language;

    private String city;

    private String province;

    private String country;

    private String avatarUrl;

    private String unionId;

    private String timestamp;

    private String appId;

    private Date cdt;

    private Date mdt;

    private String username;

    private Long userAuto;

    private String token;

    private Date tokenTime;

    private static final long serialVersionUID = 1L;
}
