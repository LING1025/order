package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "外访客户新增数据")
public class OutParamDto implements Serializable {
    /**
     * 外访客户表序号
     */
    @JsonIgnore
    private Long outBoundAuto=0L;

    @ApiModelProperty(value = "客户序号")
    private Long tradeItemAuto=0L;

    @ApiModelProperty(value = "主营业务")
    private String major;

    @ApiModelProperty(value = "经营者经营时间")
    private String operation;

    @ApiModelProperty(value = "主持企业含关企")
    private String hostCompanies;

    @ApiModelProperty(value = "设备、车辆")
    private String equipCar;

    @ApiModelProperty(value = "近三年平均营业额")
    private BigDecimal avgTurnover;

    @ApiModelProperty(value = "近一期营业额")
    private BigDecimal turnover;

    @ApiModelProperty(value = "年增长率")
    private String yearRate;

    @ApiModelProperty(value = "租车目序号")
    private Integer rentAimType;

    @ApiModelProperty(value = "租车目的")
    private String rentAim;

    @ApiModelProperty(value = "个人、企业：银行流水")
    private BigDecimal bankBill;

    @ApiModelProperty(value = "个人：工资收入；企业：财务报表")
    private BigDecimal finState;

    @ApiModelProperty(value = "个人：社保金额；企业：资金流量表")
    private BigDecimal fundsFlow;

    @ApiModelProperty(value = "个人：工作证明")
    private String taxPayment ;

    @ApiModelProperty(value = "企业：纳税凭证")
    private BigDecimal taxReceipt;

    @ApiModelProperty(value = "个人：公司股东所持份额；企业：股票代码")
    private BigDecimal stockCode;

    @ApiModelProperty(value = "个人：信用报告")
    private String creditReport;

    @ApiModelProperty(value = "担保条件序号")
    private Integer ensureType;

    @ApiModelProperty(value = "担保条件")
    private String ensure;

    @ApiModelProperty(value = "所属行业前景")
    private String vista;

    @ApiModelProperty(value = "未来预计发展规模")
    private String develop;

    @ApiModelProperty(value = "创建人")
    private Long cuser;

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date cdt;

    @ApiModelProperty(value = "所选择的签核人序号")
    private Long checkAuto;

    @ApiModelProperty(value = "所选择的签核人")
    private String checkName;

    @ApiModelProperty(value = "个人、企业：银行流水附件")
    private String file1;

    @ApiModelProperty(value = "个人：工资收入；企业：财务报表附件")
    private String file2;

    @ApiModelProperty(value = "个人：社保金额；企业：资金流量表附件")
    private String file3;

    @ApiModelProperty(value = "个人：工作证明；企业：纳税凭证附件")
    private String file4;

    @ApiModelProperty(value = "个人：公司股东所持份额；企业：股票代码附件")
    private String file5;

    @ApiModelProperty(value = "个人：信用报告附件")
    private String file6;

    @ApiModelProperty(value = "其它租车目的")
    private String otherAim;

    @ApiModelProperty(value = "担保人")
    private String ensureName;

    @ApiModelProperty(value = "身份别序号 :0个人 1公司")
    private Integer idenType;
}
