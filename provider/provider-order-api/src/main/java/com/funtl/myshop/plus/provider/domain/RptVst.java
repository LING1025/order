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
@Table(name = "[RptVst]")
public class RptVst implements Serializable {
    /**
     * 行程单号
     */
    @Id
    @Column(name = "RptVst_Auto")
    private Long rptVstAuto;

    /**
     * 对象序号
     */
    @Column(name = "TradeItem_Auto")
    private Long tradeItemAuto;

    /**
     * 拜访序号
     */
    @Column(name = "Visit_Auto")
    private Integer visitAuto;

    /**
     * 拜访方式
     */
    @Column(name = "VstType")
    private Integer vstType;

    /**
     * 拜访时间
     */
    @Column(name = "VstDT")
    private Date vstDT;

    /**
     * 拜访地点
     */
    @Column(name = "VstAddr")
    private String vstAddr;

    /**
     * 费用
     */
    @Column(name = "Fee")
    private BigDecimal fee;

    /**
     * 进度
     */
    @Column(name = "OutComing")
    private Integer outComing;

    /**
     * 目的
     */
    @Column(name = "Aim")
    private String aim;

    /**
     * 概述
     */
    @Column(name = "Summary")
    private String summary;

    /**
     * 详细内容
     */
    @Column(name = "Detail")
    private String detail;

    /**
     * 想法
     */
    @Column(name = "Thought")
    private String thought;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    @Column(name = "CUser")
    private Integer cUser;

    @Column(name = "CDT")
    private Date cdt;

    /**
     * 下次拜访时间
     */
    @Column(name = "NextVstDT")
    private Date nextVstDT;

    /**
     * 状态
     */
    @Column(name = "Status")
    private Integer status;

    /**
     * 客户来源
     */
    @Column(name = "CustSource")
    private Integer custSource;

    /**
     * 标志地图
     */
    @Column(name = "SignMap")
    private String signMap;

    /**
     * 经度
     */
    @Column(name = "SignLongitude")
    private String signLongitude;

    /**
     * 纬度
     */
    @Column(name = "SignLatitude")
    private String signLatitude;

    @Column(name = "MUser")
    private Integer mUser;

    @Column(name = "MCDT")
    private Date mcDT;

    @Column(name = "GPS_ID")
    private Integer gpsId;

    @Column(name = "img1")
    private String img1;

    @Column(name = "img2")
    private String img2;

    @Column(name = "img3")
    private String img3;

    @Column(name = "img4")
    private String img4;

    @Column(name = "img5")
    private String img5;

    @Column(name = "img6")
    private String img6;

    @Column(name = "img7")
    private String img7;

    @Column(name = "img8")
    private String img8;

    @Column(name = "img9")
    private String img9;

    @Column(name = "vstRealAddr")
    private String vstRealAddr;

    private static final long serialVersionUID = 1L;
}
