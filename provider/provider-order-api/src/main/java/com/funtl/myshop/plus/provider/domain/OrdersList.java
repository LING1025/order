package com.funtl.myshop.plus.provider.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrdersList implements Serializable {

    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "原试算单号")
    private Long ordersOld;

    @ApiModelProperty(value = "案件类别")
    private Integer postType;

    @ApiModelProperty(value = "目前状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "租赁期数")
    private Integer mm;

    @ApiModelProperty(value = "租赁性质::ItemCode.ItemType=314")
    private Integer rentType;

    @ApiModelProperty(value = "业务类别::ItemCode.ItemType=326")
    private Integer orderType;

    /**
     * 客户资料
     */

    @ApiModelProperty(value = "客户全称")
    private String fName;

    @ApiModelProperty(value = "承办业代")
    private String salesName;

    @ApiModelProperty(value = "客户来源::ItemCode.ItemType=313")
    private Integer custSource;

    @ApiModelProperty(value = "介绍人")
    private String pushMan;

    /**
     * 车籍资料
     */

    @ApiModelProperty(value = "报价车商")
    private Integer supplierBuy;

    @ApiModelProperty(value = "厂牌车型")
    private Integer factoryBrandAuto;

    @ApiModelProperty(value = "出厂年月")
    private Date cardt;

    @ApiModelProperty(value = "车色")
    private String carColor;

    @ApiModelProperty(value = "车辆来源::ItemCode.ItemType=503")
    private Integer carSource;

    @ApiModelProperty(value = "车型代码")
    private String clasenCode;

    @ApiModelProperty(value = "排气量")
    private Integer cc;

    @ApiModelProperty(value = "燃油种类::ItemCode.ItemType=231")
    private Integer oil;

    @ApiModelProperty(value = "排挡")
    private Integer bsType;

    @ApiModelProperty(value = "车号")
    private String makNo;

    @ApiModelProperty(value = "续租新车旧车号")
    private String reletMakno;

    /**
     * 牌照资料 可以看carBase表 Inc表
     */

    @ApiModelProperty(value = "公司别")
    private String carIncName;//在orders表中有公司别代码IncAuto
    /**
     * 上海牌
     */
    @ApiModelProperty(value = "牌照类别(上海牌)")
    private Integer makNoType;//在orders表

    @ApiModelProperty(value = "使用牌费")
    private BigDecimal makNoCost;//在orders表



}
