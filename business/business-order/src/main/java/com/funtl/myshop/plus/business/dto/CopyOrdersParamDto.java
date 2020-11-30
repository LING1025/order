package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "回租报价：复制试算报价单按钮")
public class CopyOrdersParamDto implements Serializable {
    @ApiModelProperty(value = "框外面显示的第1个值")
    private String status;

    @ApiModelProperty(value = "框外面显示的第2个值")
    private String msg;

    @ApiModelProperty(value = "框外面显示的第3个值 车籍序号")
    private Long carBaseAuto;

    @ApiModelProperty(value = "框外面显示的第4个值 可抵扣 0否 1是")
    private Integer chkListPrice;

    @ApiModelProperty(value = "框外面显示的第5个值 计价租金")
    private BigDecimal rateMAmt;
    /**
     * 基本信息
     */
    @ApiModelProperty(value = "回租报价序号")
    private Long postType;

    @ApiModelProperty(value = "回租报价")
    private String postTypeName;

    @ApiModelProperty(value = "原单号")
    private Long ordersOld;

    @ApiModelProperty(value = "试算单号")
    private Long ordersAuto=0L;

    @ApiModelProperty(value = "承办业代部门序号")
    private Long orgAuto;

    @ApiModelProperty(value = "承办业代部门")
    private String depName;

    @ApiModelProperty(value = "承办业代序号")
    private Long userAuto;

    @ApiModelProperty(value = "承办业代姓名")
    private String salesName;

    @ApiModelProperty(value = "业务类别序号")
    private Long orderType;

    @ApiModelProperty(value = "业务类别")
    private String orderTypeName;

    @ApiModelProperty(value = "公司别序号")
    private Long companyInc;

    @ApiModelProperty(value = "公司别")
    private String companyIncN;

    @ApiModelProperty(value = "租赁期数")
    private Integer mm;

    @ApiModelProperty(value = "客户来源序号")
    private Long custSource;

    @ApiModelProperty(value = "客户来源")
    private String custSourceName;

    @ApiModelProperty(value = "介绍人")
    private String pushMan;

    /**
     * 客户序号
     */
    @ApiModelProperty(value = "客户序号")
    private Long tradeItemAuto;

    @ApiModelProperty(value = "客户全称")//fName+tradeItemAuto+customerStatus
    private String fName;

    @JsonIgnore
    private String customerStatus;

    @ApiModelProperty(value = "大口客户 0否 1是")
    private Integer isBigTradeItem;

    @ApiModelProperty(value = "行动电话")
    private String pushTel;

    /**
     * 车籍信息
     */

    @ApiModelProperty(value = "报价车商")
    private String supplierBuyName;

    @ApiModelProperty(value = "车号")
    private String makNo;

    @ApiModelProperty(value = "车辆来源序号")
    private Long carSource;

    @ApiModelProperty(value = "车辆来源")
    private String carSourceName;

    @ApiModelProperty(value = "总厂牌序号")
    private Long factoryBrandAuto;

    @ApiModelProperty(value = "总厂牌")
    private String factoryBrandName;

    @ApiModelProperty(value = "厂牌序号")
    private Long brandAuto;

    @ApiModelProperty(value = "厂牌")
    private String brandName;

    @ApiModelProperty(value = "车型序号")
    private Long clasenAuto;

    @ApiModelProperty(value = "车型")
    private String clasenName;

    @ApiModelProperty(value = "车型代码")
    private String clasenCode;

    @ApiModelProperty(value = "抵押地序号")
    private Long mortgageAddr;

    @ApiModelProperty(value = "抵押地")
    private String mortgageAddrN;

    @ApiModelProperty(value = "出厂年月")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date cardt;

    @ApiModelProperty(value = "排气量")
    private Integer cc;

    @ApiModelProperty(value = "排挡方式序号")
    private Long bsType;

    @ApiModelProperty(value = "排挡方式")
    private String bsTypeName;

    @ApiModelProperty(value = "车色")
    private String carColor;

    @ApiModelProperty(value = "已用月数")
    private Integer mm2;

    @ApiModelProperty(value = "已用里程")
    private Integer usekm;

    @ApiModelProperty(value = "燃油种类序号")
    private Long oil;

    @ApiModelProperty(value = "燃油种类")
    private String oilName;

    @ApiModelProperty(value = "吨数")
    private String weight;

    @ApiModelProperty(value = "车险性质别序号")
    private Long insureType;

    @ApiModelProperty(value = "车险性质别")
    private String insureTypeName;

    @ApiModelProperty(value = "车险座位类别序号")
    private Long insurePercent;

    @ApiModelProperty(value = "车险座位类别")
    private String insurePercentName;

    @ApiModelProperty(value = "座位数")
    private Integer percnt;

    @ApiModelProperty(value = "汽车产地序号")
    private Long car;

    @ApiModelProperty(value = "汽车产地")
    private String carPlace;

    /**
     * 车辆成本
     */

    @ApiModelProperty(value = "车辆牌价")
    private BigDecimal listPrice = BigDecimal.valueOf(0);

    /**
     * 折价金额
     */
    @ApiModelProperty(value = "折价金额")
    private BigDecimal disPrice = BigDecimal.valueOf(0);

    /**
     * 车辆进价
     */
    @ApiModelProperty(value = "折价金额后面的值")
    private BigDecimal getPrice = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "网上参考价")
    private Long carPriceRef = 0L;

    @ApiModelProperty(value = "贴息金额")
    private BigDecimal discount = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "贷款成数(%)")
    private Long amtPNum;

    @ApiModelProperty(value = "贷款成数(%)后面的值")
    private String amtP;

    @ApiModelProperty(value = "首付金额")
    private BigDecimal dptAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "贷款成本")
    private BigDecimal rentAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "印花税")
    private BigDecimal stampTax = BigDecimal.valueOf(0);

    /**
     * 附加成本
     */

    @ApiModelProperty(value = "保险金额")
    private BigDecimal insureRealAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "配件金额")
    private BigDecimal accessary = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "GPS安装 0否 1是")
    private Integer gps;

    @ApiModelProperty(value = "GPS安装费")
    private BigDecimal gpsAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "加急费")
    private BigDecimal urgentFee = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "购置税")
    private BigDecimal carTax = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "上牌规费")
    private BigDecimal feeAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "金融费")
    private BigDecimal financeFee = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "出库费")
    private BigDecimal outFee = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "推荐佣金")
    private BigDecimal pushMoney = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "延保费")
    private BigDecimal carExtensionAmt = BigDecimal.valueOf(0);

    /**
     * 付款条件
     */
    @ApiModelProperty(value = "付款周期编号")
    private Long payMode;

    @ApiModelProperty(value = "付款周期")
    private String payModeN;

    @ApiModelProperty(value = "付款天数")
    private Integer payDay;

    /**
     * 成交概况
     */

    @ApiModelProperty(value = "年化利率(含税)")
    private BigDecimal rateTaxYear = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "退税年化利率")
    private String rentRateY;

    @ApiModelProperty(value = "租金总额")
    private BigDecimal rentAmtT = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "毛利总额")
    private BigDecimal grossMargin = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "年利率(含税)")
    private double rateRate;

    @JsonIgnore
    private BigDecimal rentRate = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "退税年利率")
    private String rentRateN;

    @ApiModelProperty(value = "增税值 %总和")
    private Integer taxMode;

    @ApiModelProperty(value = "增税值总和")
    private BigDecimal salesTax = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "毛利率")
    private String grossMarginT;

    @ApiModelProperty(value = "月租金(含税)")
    private BigDecimal rentMAmt = BigDecimal.valueOf(0);

    @ApiModelProperty(value = "退佣利率(含税)")
    private String commissionRate;

    @ApiModelProperty(value = "税额")
    private BigDecimal finalTax = BigDecimal.valueOf(0);

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
