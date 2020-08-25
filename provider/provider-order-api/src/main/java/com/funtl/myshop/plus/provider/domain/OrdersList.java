package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String postTypeName;

    @ApiModelProperty(value = "目前状态")
    private String orderStatusName;

    @ApiModelProperty(value = "租赁期数")
    private Integer mm;

    /**
     * 租赁性质::ItemCode.ItemType=314
     */
    @JsonIgnore
    private Integer rentType;

    @ApiModelProperty(value = "租赁性质")
    private String rentTypeName;

    /**
     * 业务类别::ItemCode.ItemType=326
     */
    @ApiModelProperty(value = "业务类别")
    private String orderTypeName;

    /**
     * 客户资料
     */

    @ApiModelProperty(value = "客户全称")
    private String fName;

    /**
     * 客户代码
     */
    @JsonIgnore
    private Long tradeItemAuto;

    @ApiModelProperty(value = "承办业代")
    private String salesName;

    /**
     * 客户来源::ItemCode.ItemType=313
     */

    @ApiModelProperty(value = "客户来源")
    private String custSourceName;

    @ApiModelProperty(value = "介绍人")
    private String pushMan;

    /**
     * 车籍资料
     */

    @ApiModelProperty(value = "报价车商")
    private String supplierBuyName;

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

    @ApiModelProperty(value = "出厂年月")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date cardt;

    @ApiModelProperty(value = "车色")
    private String carColor;

    /**
     * 车辆来源::ItemCode.ItemType=503
     */
    @JsonIgnore
    private Integer carSource;

    @ApiModelProperty(value = "车辆来源")
    private String carSourceName;

    @ApiModelProperty(value = "车型代码")
    private String clasenCode;

    @ApiModelProperty(value = "排气量")
    private Integer cc;

    /**
     * 燃油种类::ItemCode.ItemType=231
     */
    @ApiModelProperty(value = "燃油种类")
    private String oilName;

    @ApiModelProperty(value = "排挡方式")
    private String bsTypeName;

    @ApiModelProperty(value = "车号")
    private String makNo;

    @ApiModelProperty(value = "续租新车旧车号")
    private String reletMakNo;

    @ApiModelProperty(value = "续租新车 0 false 1 true")
    private Integer isRelet;

    /**
     * 牌照资料 可以看carBase表 Inc表
     */

    @ApiModelProperty(value = "公司别")
    private String carIncName;//在orders表中有公司别代码IncAuto
    /**
     * 上海牌
     */
    @ApiModelProperty(value = "牌照类别")
    private String makNoTypeName;

    @ApiModelProperty(value = "使用牌费")
    private BigDecimal makNoCost;//在orders表

    /**
     * 车辆成本
     */

    @ApiModelProperty(value = "牌价")
    private BigDecimal listPrice;

    @ApiModelProperty(value = "折价")
    private BigDecimal disPrice;

    @ApiModelProperty(value = "车辆进价")
    private BigDecimal getPrice;

    @ApiModelProperty(value = "网上参考价")
    private Long carPriceRef;

    @ApiModelProperty(value = "配件金额")
    private BigDecimal accessary;

    @ApiModelProperty(value = "购置税")
    private BigDecimal carTax;

    @ApiModelProperty(value = "车辆成本")
    private BigDecimal carCost;

    @ApiModelProperty(value = "佣金")
    private BigDecimal pushMoney;

    @ApiModelProperty(value = "残值")
    private String overAmtYName;

    /**
     * 残值
     */
    @JsonIgnore
    private BigDecimal overAmtY;

    /**
     * 残值后面的利率
     */
    @JsonIgnore
    private String overP;

    @ApiModelProperty(value = "保证金")
    private String dptAmtName;

    /**
     * 保证金
     */
    @JsonIgnore
    private BigDecimal dptAmt;

    /**
     * 保证金后面的第一个参数
     */
    @JsonIgnore
    private String dptTypeName;

    /**
     * 保证金后面的第二个参数
     */
    @JsonIgnore
    private String dptTaxPayN;

    /**
     * 保证金后面的第三个参数
     */
    @JsonIgnore
    private String dptP;

    @ApiModelProperty(value = "调整")
    private BigDecimal overAmt;

    @ApiModelProperty(value = "承租车价")
    private BigDecimal rentAmt;

    @ApiModelProperty(value = "成本调整")
    private BigDecimal costAdjustment;

    @ApiModelProperty(value = "承购")
    private BigDecimal repurchaseAmt;

    @ApiModelProperty(value = "代垫利息成本")
    private BigDecimal dptTax;

    @ApiModelProperty(value = "延保费")
    private BigDecimal carExtensionAmt;

    @ApiModelProperty(value = "出库费")
    private BigDecimal outFee;

    @ApiModelProperty(value = "金融费")
    private BigDecimal financeFee;

    @ApiModelProperty(value = "加急费")
    private BigDecimal urgentFee;

    /**
     * 税费资料
     */

    @ApiModelProperty(value = "印花税")
    private BigDecimal stampTax;

    @ApiModelProperty(value = "售车税")
    private BigDecimal sellCarTax;

    @ApiModelProperty(value = "过户费")
    private BigDecimal trnsFee;


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
     * 费用明细
     */

    /**
     * 佣金人
     */

    /**
     * 保险内容
     */
    @ApiModelProperty(value = "性质类别")
    private String insureTypeName;

    @ApiModelProperty(value = "座位类别")
    private String insurePercntName;

    @ApiModelProperty(value = "座位数")
    private Integer percnt;

    @ApiModelProperty(value = "产地")
    private String carPlace;

    /*@JsonIgnore
    private BigDecimal insureRealAmt;

    @ApiModelProperty(value = "保险成本(年)")
    private String InsureYG;*/

    /**
     * 配件明细
     */

    /**
     * 实际成交概况
     */

    @ApiModelProperty(value = "租金总额")
    private BigDecimal rentAmtT;
    @ApiModelProperty(value = "内部报酬率")
    private String irr;
    @ApiModelProperty(value = "毛利总额")
    private BigDecimal grossMargin;
    @ApiModelProperty(value = "毛利率")
    private String grossMarginT;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
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

    /**
     * 签核明细
     */
}
