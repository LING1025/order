package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[WxEncryptedData]")
public class WxEncryptedData implements Serializable {
    @Id
    @Column(name = "Id")
    private Long id;

    @Column(name = "OpenId")
    private String openId;

    @Column(name = "NickName")
    private String nickName;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Language")
    private String language;

    @Column(name = "City")
    private String city;

    @Column(name = "Province")
    private String province;

    @Column(name = "Country")
    private String country;

    @Column(name = "AvatarUrl")
    private String avatarUrl;

    @Column(name = "UnionId")
    private String unionId;

    @Column(name = "Timestamp")
    private String timestamp;

    @Column(name = "Appid")
    private String appId;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "MDT")
    private Date mdt;

    @Column(name = "UserName")
    private String username;

    @Column(name = "User_Auto")
    private Long userAuto;

    @Column(name = "Token")
    private String token;

    @Column(name = "TokenTime")
    private Date tokenTime;

    private static final long serialVersionUID = 1L;
}
