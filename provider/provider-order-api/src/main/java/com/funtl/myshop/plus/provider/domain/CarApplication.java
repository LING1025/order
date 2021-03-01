package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
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
     * 使用人序号
     */
    @Column(name = "UserAuto")
    private Long userAuto;

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
     * 钥匙是否归还：0否 1是
     */
    @Column(name = "IsBack")
    private Integer isBack;

    /**
     * 归还钥匙人
     */
    @Column(name = "giveBackUser")
    private Long giveBackUser;

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
    * '-1取消、0暂存、5驳回、10送件、20核准、30出车、40还车、21待取车
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

    /**
     * 起始地
     */
    @Column(name = "startAddr")
    private String startAddr;

    /**
     * 起始地纬度
     */
    @Column(name = "startAddrLat")
    private String startAddrLat;

    /**
     * 起始地经度
     */
    @Column(name = "startAddrLng")
    private String startAddrLng;

    /**
     * 目的地
     */
    @Column(name = "endAddr")
    private String endAddr;

    /**
     * 目的地纬度
     */
    @Column(name = "endAddrLat")
    private String endAddrLat;

    /**
     * 目的地经度
     */
    @Column(name = "endAddrLng")
    private String endAddrLng;

    /**
     * 距离：公里
     */
    @Column(name = "distance")
    private Double distance;

    /**
     * 牌照地区序号
     */
    @Column(name = "areaType")
    private Integer areaType;

    /**
     * 是否发放钥匙 ：0否 1是
     */
    @Column(name = "IsGive")
    private Integer isGive;

    /**
     * 是否领取钥匙 ：0否 1是
     */
    @Column(name = "IsGet")
    private Integer isGet;

    /**
     * 发放钥匙人
     */
    @Column(name = "giveKeyUser")
    private Long giveKeyUser;

    /**
     * 发放钥匙时间
     */
    @Column(name = "giveKeyDT")
    private Date giveKeyDT;

    /**
     * 领取钥匙人
     */
    @Column(name = "getKeyUser")
    private Long getKeyUser;

    /**
     * 领取钥匙时间
     */
    @Column(name = "getKeyDT")
    private Date getKeyDT;

    /**
     * 仪表盘起始里程图片
     */
    @Column(name = "startImg")
    private String startImg;

    /**
     * 仪表盘归还里程图片
     */
    @Column(name = "endImg")
    private String endImg;

    /**
     * 车身照左侧
     */
    @Column(name = "leftImg")
    private String leftImg;

    /**
     * 车身照右侧
     */
    @Column(name = "rightImg")
    private String rightImg;

    /**
     * 车身照后部
     */
    @Column(name = "behindImg")
    private String behindImg;

    /**
     * 起始里程拍照时间
     */
    @Column(name = "time1")
    private Date time1;

    /**
     * 归还里程拍照时间
     */
    @Column(name = "time2")
    private Date time2;

    /**
     * 车身左侧拍照时间
     */
    @Column(name = "time3")
    private Date time3;

    /**
     * 车身右侧拍照时间
     */
    @Column(name = "time4")
    private Date time4;

    /**
     * 车身后部拍照时间
     */
    @Column(name = "time5")
    private Date time5;

    /**
     * 起始里程拍照地址
     */
    @Column(name = "address1")
    private String address1;

    /**
     * 归还里程拍照地址
     */
    @Column(name = "address2")
    private String address2;

    /**
     * 车身左侧拍照地址
     */
    @Column(name = "address3")
    private String address3;

    /**
     * 车身右侧拍照地址
     */
    @Column(name = "address4")
    private String address4;

    /**
     * 车身后部拍照地址
     */
    @Column(name = "address5")
    private String address5;

    /**
     * 途经地1
     */
    @Column(name = "passAddr1")
    private String passAddr1;

    /**
     * 途经地1纬度
     */
    @Column(name = "passAddrLat1")
    private String passAddrLat1;

    /**
     * 途经地1经度
     */
    @Column(name = "passAddrLng1")
    private String passAddrLng1;

    /**
     * 途经地2
     */
    @Column(name = "passAddr2")
    private String passAddr2;

    /**
     * 途经地2纬度
     */
    @Column(name = "passAddrLat2")
    private String passAddrLat2;

    /**
     * 途经地2经度
     */
    @Column(name = "passAddrLng2")
    private String passAddrLng2;

    /**
     * 途经地3
     */
    @Column(name = "passAddr3")
    private String passAddr3;

    /**
     * 途经地3纬度
     */
    @Column(name = "passAddrLat3")
    private String passAddrLat3;

    /**
     * 途经地3经度
     */
    @Column(name = "passAddrLng3")
    private String passAddrLng3;

    /**
     * 途经地4
     */
    @Column(name = "passAddr4")
    private String passAddr4;

    /**
     * 途经地4纬度
     */
    @Column(name = "passAddrLat4")
    private String passAddrLat4;

    /**
     * 途经地4经度
     */
    @Column(name = "passAddrLng4")
    private String passAddrLng4;

    /**
     * 途经地5
     */
    @Column(name = "passAddr5")
    private String passAddr5;

    /**
     * 途经地5纬度
     */
    @Column(name = "passAddrLat5")
    private String passAddrLat5;

    /**
     * 途经地5经度
     */
    @Column(name = "passAddrLng5")
    private String passAddrLng5;

    /**
     * 用车累计费用金额
     */
    @Column(name = "useCarAmt")
    private BigDecimal useCarAmt;

    private static final long serialVersionUID = 1L;
}
