package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class CarApplication implements Serializable {
    private Long carApplicationAuto;

    /**
    * 申请人
    */
    private Integer appUser;

    /**
    * 申请日期
    */
    private Date appDT;

    /**
    * 申请事由
    */
    private Integer appType;

    /**
    * 加油类别
    */
    private Integer feeType;

    private BigDecimal feeAmt;

    /**
    * 还车仓库ItemType = 826
    */
    private Integer wHType;

    /**
    * 预估开始时间
    */
    private Date planStartDT;

    /**
    * 预估还车时间
    */
    private Date planEndDT;

    /**
    * 客户名称
    */
    private String fName;

    /**
    * 使用人
    */
    private String username;

    /**
    * 支援驾驶
    */
    private Integer isDriver;

    /**
    * 驾驶人员
    */
    private String driverUserAuto;

    /**
    * 申请车辆
    */
    private Long appCarbaseAuto;

    /**
    * 特殊需求
    */
    private String specialMemo;

    /**
    * 事由说明
    */
    private String licenceMemo;

    /**
    * 承租车辆
    */
    private Long carbaseAuto;

    /**
    * 出车时间
    */
    private Date startDT;

    /**
    * 出车油表ItemType = 828
    */
    private Integer oilGaugeOut;

    /**
    * 出车里程
    */
    private BigDecimal mileageOut;

    /**
    * 加油卡卡号
    */
    private String oilCardNum;

    /**
    * 入车时间
    */
    private Date endDT;

    /**
    * 入车油表ItemType = 828
    */
    private Integer oilGaugeIn;

    /**
    * 入车里程
    */
    private BigDecimal mileageIn;

    /**
    * 入车备注
    */
    private String memo;

    /**
    * '-1取消、0暂存、5驳回、10送件、20核准、30出车、40还车
    */
    private Integer status;

    private Integer cUser;

    private Date cDT;

    private Integer mUser;

    private Date mDT;

    /**
    * 加油里程
    */
    private Integer oilKM;

    /**
    * 加油油量
    */
    private BigDecimal oilKG;

    /**
    * 过路费
    */
    private BigDecimal roadFee;

    /**
    * 停车费
    */
    private BigDecimal parkingFee;

    /**
    * 是否提前申请 1是  0否
    */
    private Integer isSave;

    private static final long serialVersionUID = 1L;
}