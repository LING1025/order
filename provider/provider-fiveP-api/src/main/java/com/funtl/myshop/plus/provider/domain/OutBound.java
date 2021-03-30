package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[outBound]")
public class OutBound implements Serializable {
    /**
    * 外访客户表序号
    */
    @Id
    @Column(name = "")
    private Long outBoundAuto;

    /**
    * 客户序号
    */
    @Column(name = "")
    private Long tradeItemAuto;

    /**
    * 主营业务
    */
    @Column(name = "")
    private String major;

    /**
    * 经营者经营时间
    */
    @Column(name = "")
    private String operation;

    /**
    * 主持企业含关企
    */
    @Column(name = "")
    private String hostCompanies;

    /**
    * 设备、车辆
    */
    @Column(name = "")
    private String equipCar;

    /**
    * 近三年平均营业额
    */
    @Column(name = "")
    private String avgTurnover;

    /**
    * 近一期营业额
    */
    @Column(name = "")
    private String turnover;

    /**
    * 年增长率
    */
    @Column(name = "")
    private String yearRate;

    /**
    * 租车目序号
    */
    @Column(name = "")
    private Integer rentAimType;

    /**
    * 租车目的
    */
    @Column(name = "")
    private String rentAim;

    /**
    * 银行流水
    */
    @Column(name = "")
    private BigDecimal bankBill;

    /**
    * 财务报表
    */
    @Column(name = "")
    private BigDecimal finState;

    /**
    * 资金流量表
    */
    @Column(name = "")
    private BigDecimal fundsFlow;

    /**
    * 纳税凭证
    */
    @Column(name = "")
    private BigDecimal taxReceipt;

    /**
    * 股票代码
    */
    @Column(name = "")
    private BigDecimal stockCode;

    /**
    * 担保条件序号
    */
    @Column(name = "")
    private Integer ensureType;

    /**
    * 担保条件
    */
    @Column(name = "")
    private String ensure;

    /**
    * 所属行业前景
    */
    @Column(name = "")
    private String vista;

    /**
    * 未来预计发展规模
    */
    @Column(name = "")
    private String develop;

    /**
    * 创建人
    */
    @Column(name = "")
    private Long cuser;

    /**
    * 创建时间
    */
    @Column(name = "")
    private Date cdt;

    /**
    * 修改人
    */
    @Column(name = "")
    private Long muser;

    /**
    * 修改时间
    */
    @Column(name = "")
    private Date mdt;

    private static final long serialVersionUID = 1L;
}
