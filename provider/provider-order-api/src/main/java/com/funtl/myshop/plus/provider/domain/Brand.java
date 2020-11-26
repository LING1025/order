package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[Brand]")
public class Brand implements Serializable {
    /**
    * 廠牌序號
    */
    @Id
    @Column(name = "Brand_Auto")
    private Long brandAuto;

    /**
    * 廠牌名稱
    */
    @Column(name = "BrandName")
    private String brandName;

    @Column(name = "CDT")
    private Date cDT;

    @Column(name = "CUser")
    private Long cUser;

    @Column(name = "MDT")
    private Date mDT;

    @Column(name = "MUser")
    private Long mUser;

    @Column(name = "FactoryBrand_Auto")
    private Integer factoryBrandAuto;

    private static final long serialVersionUID = 1L;
}
