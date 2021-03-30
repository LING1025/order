package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[outCheck]")
public class OutCheck implements Serializable {
    /**
    * 外访签核表序号
    */
    @Id
    @Column(name = "outCheckAuto")
    private Long outCheckAuto;

    /**
    * 外访客户表序号
    */
    @Column(name = "outBoundAuto")
    private Long outBoundAuto;

    /**
    * 签核人序号
    */
    @Column(name = "checkAuto")
    private Long checkAuto;

    /**
    * 签核人
    */
    @Column(name = "checkName")
    private String checkName;

    /**
    * 签核时间
    */
    @Column(name = "checkDT")
    private Date checkDT;

    /**
    * 签核状态：1未审核 2核准 3驳回
    */
    @Column(name = "checkStatus")
    private Integer checkStatus;

    /**
    * 签核意见
    */
    @Column(name = "memo")
    private String memo;

    /**
    * 创建人
    */
    @Column(name = "cuser")
    private Long cuser;

    /**
    * 创建时间
    */
    @Column(name = "cdt")
    private Date cdt;

    /**
    * 修改人
    */
    @Column(name = "muser")
    private Long muser;

    /**
    * 修改时间
    */
    @Column(name = "mdt")
    private Date mdt;

    private static final long serialVersionUID = 1L;
}
