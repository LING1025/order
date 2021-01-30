package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[CarApplication]")
public class CarApplication implements Serializable {
    /**
     * 用车申请序号
     */
    @Id
    @Column(name = "CarApplication_Auto")
    private Long carApplicationAuto;

    /**
    * 申请人
    */
    @Column(name = "AppUser")
    private Integer appUser;

    /**
    * 申请日期
    */
    @Column(name = "AppDT")
    private Date appDT;

    /**
    * 申请事由
    */
    @Column(name = "AppType")
    private Integer appType;

    /**
    * 加油类别
    */
    @Column(name = "FeeType")
    private Integer feeType;

    @Column(name = "FeeAmt")
    private BigDecimal feeAmt;

    /**
    * 还车仓库ItemType = 826
    */
    @Column(name = "WHType")
    private Integer wHType;

    /**
    * 预估开始时间
    */
    @Column(name = "PlanStartDT")
    private Date planStartDT;

    /**
    * 预估还车时间
    */
    @Column(name = "PlanEndDT")
    private Date planEndDT;

    /**
    * 客户名称
    */
    @Column(name = "Fname")
    private String fName;

    /**
    * 使用人
    */
    @Column(name = "UserName")
    private String username;

    /**
    * 支援驾驶
    */
    @Column(name = "IsDriver")
    private Integer isDriver;

    /**
    * 驾驶人员
    */
    @Column(name = "DriverUser_Auto")
    private String driverUserAuto;

    /**
    * 申请车辆
    */
    @Column(name = "AppCarbase_Auto")
    private Long appCarbaseAuto;

    /**
    * 特殊需求
    */
    @Column(name = "SpecialMemo")
    private String specialMemo;

    /**
    * 事由说明
    */
    @Column(name = "LicenceMemo")
    private String licenceMemo;

    /**
    * 承租车辆
    */
    @Column(name = "Carbase_Auto")
    private Long carBaseAuto;

    /**
    * 出车时间
    */
    @Column(name = "StartDT")
    private Date startDT;

    /**
    * 出车油表ItemType = 828
    */
    @Column(name = "OilGaugeOut")
    private Integer oilGaugeOut;

    /**
    * 出车里程
    */
    @Column(name = "MileageOut")
    private BigDecimal mileageOut;

    /**
    * 加油卡卡号
    */
    @Column(name = "OilCardNum")
    private String oilCardNum;

    /**
    * 入车时间
    */
    @Column(name = "EndDT")
    private Date endDT;

    /**
    * 入车油表ItemType = 828
    */
    @Column(name = "OilGaugeIn")
    private Integer oilGaugeIn;

    /**
    * 入车里程
    */
    @Column(name = "MileageIn")
    private BigDecimal mileageIn;

    /**
    * 入车备注
    */
    @Column(name = "Memo")
    private String memo;

    /**
    * '-1取消、0暂存、5驳回、10送件、20核准、30出车、40还车
    */
    @Column(name = "Status")
    private Integer status;

    @Column(name = "CUser")
    private Integer cUser;

    @Column(name = "CDT")
    private Date cdt;

    @Column(name = "MUser")
    private Integer mUser;

    @Column(name = "MDT")
    private Date mdt;

    /**
    * 加油里程
    */
    @Column(name = "OilKM")
    private Integer oilKM;

    /**
    * 加油油量
    */
    @Column(name = "OilKG")
    private BigDecimal oilKG;

    /**
    * 过路费
    */
    @Column(name = "RoadFee")
    private BigDecimal roadFee;

    /**
    * 停车费
    */
    @Column(name = "ParkingFee")
    private BigDecimal parkingFee;

    /**
    * 是否提前申请 1是  0否
    */
    @Column(name = "IsSave")
    private Integer isSave;

    /**
     * 是否假日用车：0否 1是
     */
    @Column(name = "IsHoliday")
    private Integer isHoliday;

    /**
     * 用车时间:单位小时
     */
    @Column(name = "useCarTime")
    private BigDecimal useCarTime;
    private static final long serialVersionUID = 1L;
}
