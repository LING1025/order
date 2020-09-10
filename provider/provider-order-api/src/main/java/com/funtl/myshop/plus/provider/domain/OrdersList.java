package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "直租数据")
public class OrdersList implements Serializable {
    @ApiModelProperty(value = "试算单号框外面显示的第一个值")
    private String isBigTra;

    @ApiModelProperty(value = "试算单号框外面显示的第二个值")
    private String projectName;

    @ApiModelProperty(value = "试算单号框外面显示的第三个值")
    private String msg;

    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto;

    @ApiModelProperty(value = "原试算单号")
    private Long ordersOld;

    @ApiModelProperty(value = "前端用于判断")
    private Integer postType;

    @ApiModelProperty(value = "案件类别")
    private String postTypeName;

    @ApiModelProperty(value = "目前状态")
    private String orderStatusName;

    @ApiModelProperty(value = "租赁期数")
    private Integer mm;

    /**
     * 租赁性质::ItemCode.ItemType=314
     */
//    @JsonIgnore
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

    @JsonIgnore
    private String customerStatus;

    @ApiModelProperty(value = "承办业代")
    private String salesName;

    /**
     * 客户来源::ItemCode.ItemType=313
     */

    @ApiModelProperty(value = "客户来源")
    private String custSourceName;

    @ApiModelProperty(value = "介绍人")
    private String pushMan;

    @JsonIgnore
    private String pushTel;

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

    /**
     * 车籍序號
     */
    @JsonIgnore
    private Long carBaseAuto;

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
    private BigDecimal makNoCost = BigDecimal.valueOf(0);//在orders表

    /**
     * 车辆成本
     */

    @ApiModelProperty(value = "牌价")
    private BigDecimal listPrice = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "折价")
    private BigDecimal disPrice = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "车辆进价")
    private BigDecimal getPrice = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "网上参考价")
    private Long carPriceRef = 0L;

    @ApiModelProperty(value = "配件金额")
    private BigDecimal accessary = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "购置税")
    private BigDecimal carTax = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "车辆成本")
    private BigDecimal carCost = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "佣金")
    private BigDecimal pushMoney = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "残值")
    private String overAmtYName;

    /**
     * 残值
     */
//    @JsonIgnore
    private BigDecimal overAmtY = BigDecimal.valueOf(0);

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
    private BigDecimal dptAmt = BigDecimal.valueOf(0);

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
    private BigDecimal overAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "承租车价")
    private BigDecimal rentAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "成本调整")
    private BigDecimal costAdjustment = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "承购")
    private BigDecimal repurchaseAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "代垫利息成本")
    private BigDecimal dptTax = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "延保费")
    private BigDecimal carExtensionAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "出库费")
    private BigDecimal outFee = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "金融费")
    private BigDecimal financeFee = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "加急费")
    private BigDecimal urgentFee = BigDecimal.valueOf(0);

    /**
     * 税费资料
     */

    @ApiModelProperty(value = "印花税")
    private BigDecimal stampTax = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "售车税")
    private BigDecimal sellCarTax = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "过户费")
    private BigDecimal trnsFee = BigDecimal.valueOf(0);


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
    @ApiModelProperty(value = "上牌规费明细表上面的值")
    private String budgetMemo;

    @JsonIgnore
    private BigDecimal budget01Y = BigDecimal.valueOf(0);

    /**
     * 佣金人
     */

    /**
     * 保险内容
     */
    @JsonIgnore
    private Integer isCustomerCare;

    @JsonIgnore
    private String customerCareName;

    @ApiModelProperty(value = "保险内容框标题后的显示")
    private String insureIsOffer;

    @ApiModelProperty(value = "性质别")
    private String insureTypeName;

    @ApiModelProperty(value = "座位别")
    private String insurePercntName;

    @ApiModelProperty(value = "座位数")
    private Integer percnt;

    @ApiModelProperty(value = "产地")
    private String carPlace;

    @ApiModelProperty(value = "报告书")
    private String a6;

    @ApiModelProperty(value = "保险保单")
    private String a7;

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
    private BigDecimal rentAmtT = BigDecimal.valueOf(0);
    @ApiModelProperty(value = "内部报酬率")
    private String irr;
    @ApiModelProperty(value = "毛利总额")
    private BigDecimal grossMargin = BigDecimal.valueOf(0);
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
    @JsonIgnore
    private Integer onetime;

    @ApiModelProperty(value = "签核明细表标题后的字")
    private String onetimeName;
}
