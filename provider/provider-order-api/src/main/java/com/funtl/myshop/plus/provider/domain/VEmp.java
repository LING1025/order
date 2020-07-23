package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "[v_Emp]")
public class VEmp implements Serializable {

    @Column(name = "UPOrg4Name")
    private String uPOrg4Name;

    @Column(name = "UPOrg5")
    private Long uPOrg5;

    @Column(name = "UPOrg3Name")
    private String uPOrg3Name;

    @Column(name = "UPOrg4")
    private Long uPOrg4;

    @Column(name = "UPOrg2Name")
    private String uPOrg2Name;

    @Column(name = "UPOrg3")
    private Long uPOrg3;

    @Column(name = "UPOrgName")
    private String uPOrgName;

    @Column(name = "UPOrg2")
    private Long uPOrg2;

    @Column(name = "TradeItem_Auto")
    private Long tradeItemAuto;

    @Column(name = "UserId")
    private Object userId;

    @Column(name = "User_Auto")
    private Long userAuto;

    @Column(name = "UserName")
    private String userName;

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

    @Column(name = "IsOn")
    private Integer isOn;

    @Column(name = "IsEas")
    private Integer isEas;

    @Column(name = "AccCode")
    private String accCode;

    @Column(name = "IsSalesDep")
    private Integer isSalesDep;

    private static final long serialVersionUID = 1L;
}
