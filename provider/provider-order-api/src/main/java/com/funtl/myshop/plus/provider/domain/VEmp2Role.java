package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "[v_Emp2Role]")
public class VEmp2Role implements Serializable {
    @Column(name = "UserId")
    private Object userId;

    @Column(name = "User_Auto")
    private Long userAuto;

    @Column(name = "Org_Auto")
    private Long orgAuto;

    @Column(name = "DepCode")
    private String depCode;

    @Column(name = "Lev")
    private Integer lev;

    @Column(name = "UpUnit")
    private Long upUnit;

    @Column(name = "TitleLevel")
    private Integer titleLevel;

    @Column(name = "EmpBase_Auto")
    private Long empBaseAuto;

    @Column(name = "DepName")
    private String depName;

    @Column(name = "TitleName")
    private String titleName;

    @Column(name = "FName")
    private String fName;

    @Column(name = "UserName")
    private String username;

    @Column(name = "IsOn")
    private Integer isOn;

    @Column(name = "RoleName")
    private String roleName;

    private static final long serialVersionUID = 1L;
}
