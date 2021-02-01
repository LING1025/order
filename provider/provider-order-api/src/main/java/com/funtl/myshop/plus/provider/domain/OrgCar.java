package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "[Org_Car]")
public class OrgCar implements Serializable {
    @Column(name = "Org_Auto")
    private Integer orgAuto;

    @Column(name = "Carbase_Auto")
    private Long carBaseAuto;

    /**
    * 1启用、0不启用
    */
    @Column(name = "IsOn")
    private Integer isOn;

    /**
    * 1正常、0删除
    */
    @Column(name = "Status")
    private Integer status;

    @Column(name = "CUser")
    private Integer cUser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "Muser")
    private Integer mUser;

    @Column(name = "MDT")
    private Date MDT;

    private static final long serialVersionUID = 1L;
}
