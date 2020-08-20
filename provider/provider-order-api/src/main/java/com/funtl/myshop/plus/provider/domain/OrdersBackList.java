package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "回租报价数据")
public class OrdersBackList implements Serializable {
    /**
     * 基本信息
     */

    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "原单号")
    private Long ordersOld;

    @ApiModelProperty(value = "承办业代")
    private String salesName;

    /**
     * 业务类别::ItemCode.ItemType=326
     */
    @ApiModelProperty(value = "业务类别")
    private String orderTypeName;

    @ApiModelProperty(value = "公司别")
    private String carIncName;

    @ApiModelProperty(value = "租赁期数")
    private Integer mm;

    /**
     * 客户来源::ItemCode.ItemType=313
     */
    @ApiModelProperty(value = "客户来源")
    private String custSourceName;

    @ApiModelProperty(value = "介绍人")
    private String pushMan;

    @ApiModelProperty(value = "客户全称")
    private String fName;

    /**
     * 客户代码
     */
    @JsonIgnore
    private Long tradeItemAuto;

    @JsonIgnore
    private Integer customerStatus;

    @JsonIgnore
    private Integer isBigTra;

    @ApiModelProperty(value = "行动电话")
    private String pushTel;

    /**
     * 车籍信息
     */

    @ApiModelProperty(value = "报价车商")
    private String supplierBuyName;

    @ApiModelProperty(value = "车号")
    private String makNo;

    /**
     * 车辆来源::ItemCode.ItemType=503
     */
    @ApiModelProperty(value = "车辆来源")
    private String carSourceName;

    @ApiModelProperty(value = "厂牌车型")
    private String factoryBrandName;

    /**
     * 厂牌
     */
    @JsonIgnore
    private String brandName;

    /**
     * 车型
     */
    @JsonIgnore
    private String clasenName;

    @ApiModelProperty(value = "车型代码")
    private String clasenCode;

    @ApiModelProperty(value = "抵押地")
    private String mortgageAddrN;

    @ApiModelProperty(value = "出厂年月")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date cardt;

    @ApiModelProperty(value = "排气量")
    private Integer cc;

    @ApiModelProperty(value = "排挡方式")
    private String bsTypeName;

    @ApiModelProperty(value = "车色")
    private String carColor;

    @ApiModelProperty(value = "已用月数")
    private Integer mm2;

    @ApiModelProperty(value = "已用里程")
    private Integer usekm;

    /**
     * 燃油种类::ItemCode.ItemType=231
     */
    @ApiModelProperty(value = "燃油种类")
    private String oilName;

    @ApiModelProperty(value = "吨数")
    private String weight;

    /**
     * 车险性质别::ItemCode.ItemType=411
     */
    /*@JsonIgnore
    private Integer insureType;*/

    @ApiModelProperty(value = "车险性质别")
    private String insureTypeName;

    @ApiModelProperty(value = "车险座位类别")
    private String insurePercntName;

    @ApiModelProperty(value = "座位数")
    private Integer percnt;

    @ApiModelProperty(value = "汽车产地")
    private String carPlace;

    /**
     * 车辆成本
     */

    @ApiModelProperty(value = "车辆牌价")
    private BigDecimal listPrice;

    @ApiModelProperty(value = "折价金额")
    private BigDecimal disPrice;

    @ApiModelProperty(value = "网上参考价")
    private Long carPriceRef;

    @ApiModelProperty(value = "贴息金额")
    private BigDecimal discount;

    @ApiModelProperty(value = "贷款成数(%)")
    private String amtP;

    @ApiModelProperty(value = "首付金额")
    private BigDecimal dptAmt;

    @ApiModelProperty(value = "贷款成本")
    private BigDecimal rentAmt;

    @ApiModelProperty(value = "印花税")
    private BigDecimal stampTax;

    /**
     * 附加成本
     */

    @ApiModelProperty(value = "保险金额")
    private BigDecimal insureRealAmt;

    @ApiModelProperty(value = "配件金额")
    private BigDecimal accessary;

    @ApiModelProperty(value = "0否 1是")
    private Integer gps;

    @ApiModelProperty(value = "GPS安装")
    private BigDecimal gpsAmt;

    @ApiModelProperty(value = "加急费")
    private BigDecimal urgentFee;

    @ApiModelProperty(value = "购置税")
    private BigDecimal carTax;

    @ApiModelProperty(value = "上牌规费")
    private BigDecimal feeAmt;

    @ApiModelProperty(value = "金融费")
    private BigDecimal financeFee;

    @ApiModelProperty(value = "出库费")
    private BigDecimal outFee;

    @ApiModelProperty(value = "推荐佣金")
    private BigDecimal pushMoney;

    @ApiModelProperty(value = "延保费")
    private BigDecimal carExtensionAmt;

    /**
     * 付款条件
     */

    /**
     * 付款周期::ItemCode.ItemType=316
     */
    @ApiModelProperty(value = "付款周期")
    private Integer payMode;

    @ApiModelProperty(value = "付款天数")
    private Integer payDay;

    /**
     * 成交概况
     */

    @ApiModelProperty(value = "年化利率(含税)")
    private String rateTaxy;

    @ApiModelProperty(value = "退税年化利率")
    private String rentRateY;

    @ApiModelProperty(value = "租金总额")
    private BigDecimal rentAmtT;

    @ApiModelProperty(value = "毛利总额")
    private BigDecimal grossMargin;

    @ApiModelProperty(value = "年利率(含税)")
    private String rateRate;

    @ApiModelProperty(value = "退税年利率")
    private String rentRate;

    @ApiModelProperty(value = "增税值 %总和")
    private Integer taxMode;

    @ApiModelProperty(value = "增税值总和")
    private BigDecimal salesTax;

    @ApiModelProperty(value = "毛利率")
    private String grossMarginT;

    @ApiModelProperty(value = "月租金(含税)")
    private BigDecimal rentMAmt;

    @ApiModelProperty(value = "退佣利率(含税)")
    private String commissionRate;

    @ApiModelProperty(value = "税额")
    private BigDecimal finalTax;

    @ApiModelProperty(value = "内部报酬率（IRR）")
    private String irr;

    /**
     * 承租观点
     */
    @ApiModelProperty(value = "承租观点")
    private String memo;

    /**
     * 附件
     */
    @ApiModelProperty(value = "附件1")
    private String a1;

    @ApiModelProperty(value = "附件2")
    private String a2;

    @ApiModelProperty(value = "附件3")
    private String a3;

    @ApiModelProperty(value = "附件4")
    private String a4;

    @ApiModelProperty(value = "附件5")
    private String a5;
}
