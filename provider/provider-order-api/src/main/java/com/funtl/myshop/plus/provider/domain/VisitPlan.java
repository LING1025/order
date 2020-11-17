package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[VisitPlan]")
public class VisitPlan implements Serializable {
    @Id
    @Column(name = "VisitID")
    private Long visitId;

    @Column(name = "Visit_Auto")
    private Integer visitAuto;

    @Column(name = "TradeItem_Auto")
    private Integer tradeItemAuto;

    @Column(name = "Customer_Auto")
    private String customerAuto;

    @Column(name = "Contact_Auto")
    private String contactAuto;

    @Column(name = "VstDate")
    private Date vstDate;

    @Column(name = "VstType")
    private Integer vstType;

    @Column(name = "VstAddr")
    private String vstAddr;

    @Column(name = "VstAim")
    private String vstAim;

    @Column(name = "Remark")
    private String remark;

    @Column(name = "IsVsted")
    private Boolean isVsted;

    @Column(name = "CUser")
    private Integer cuser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "Addr_Province")
    private Long addrProvince;

    @Column(name = "Addr_City")
    private Long addrCity;

    @Column(name = "Addr_Street")
    private Long addrStreet;

    /**
    * 车辆申请序号
    */
    @Column(name = "FreeCarApply_Auto")
    private Long freeCarApplyAuto;

    /**
    * 停车总额
    */
    @Column(name = "ParkFee")
    private BigDecimal parkFee;

    /**
    * 停车费张数
    */
    @Column(name = "ParkCount")
    private Integer parkCount;

    /**
    * 过路费总额
    */
    @Column(name = "PassFee")
    private BigDecimal passFee;

    /**
    * 过路费张数
    */
    @Column(name = "PassCount")
    private Integer passCount;

    /**
    * 是否自费加油(0:否，1:是)
    */
    @Column(name = "Isoneself")
    private Integer isOneSelf;

    /**
    * 加油里程
    */
    @Column(name = "Refuel")
    private Double refuel=0.0;

    /**
    * 到访里程
    */
    @Column(name = "VstMile")
    private Double vstMile=0.0;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "MUser")
    private Long muser;

    @Column(name = "MDT")
    private Date mdt;

    @Column(name = "GPS_ID")
    private Integer gpsId;

    private static final long serialVersionUID = 1L;
}
