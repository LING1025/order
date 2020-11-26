package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[FactoryBrand]")
public class FactoryBrand implements Serializable {
    /**
    * 总廠牌序號
    */
    @Id
    @Column(name = "FactoryBrand_Auto")
    private Long factoryBrandAuto;

    /**
    * 总廠牌名稱
    */
    @Column(name = "FactoryBrandName")
    private String factoryBrandName;

    @Column(name = "CDT")
    private Date cDT;

    @Column(name = "CUser")
    private Long cUser;

    @Column(name = "MDT")
    private Date mDT;

    @Column(name = "MUser")
    private Long mUser;

    private static final long serialVersionUID = 1L;
}
