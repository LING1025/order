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
    @Column(name = "outBoundAuto")
    private Long outBoundAuto;

    /**
    * 客户序号
    */
    @Column(name = "tradeItemAuto")
    private Long tradeItemAuto;

    /**
     * 状态:1送件中 2核准 3驳回
     */
    @Column(name = "status")
    private Integer status;

    /**
    * 主营业务
    */
    @Column(name = "major")
    private String major;

    /**
    * 经营者经营时间
    */
    @Column(name = "operation")
    private String operation;

    /**
    * 主持企业含关企
    */
    @Column(name = "hostCompanies")
    private String hostCompanies;

    /**
    * 设备、车辆
    */
    @Column(name = "equipCar")
    private String equipCar;

    /**
    * 近三年平均营业额
    */
    @Column(name = "avgTurnover")
    private BigDecimal avgTurnover;

    /**
    * 近一期营业额
    */
    @Column(name = "turnover")
    private BigDecimal turnover;

    /**
    * 年增长率
    */
    @Column(name = "yearRate")
    private String yearRate;

    /**
    * 租车目序号
    */
    @Column(name = "rentAimType")
    private Integer rentAimType;

    /**
    * 租车目的
    */
    @Column(name = "rentAim")
    private String rentAim;

    /**
    * 银行流水
    */
    @Column(name = "bankBill")
    private BigDecimal bankBill;

    /**
    * 财务报表
    */
    @Column(name = "finState")
    private BigDecimal finState;

    /**
    * 资金流量表
    */
    @Column(name = "fundsFlow")
    private BigDecimal fundsFlow;

    /**
    * 纳税凭证
    */
    @Column(name = "taxReceipt")
    private BigDecimal taxReceipt;

    /**
    * 股票代码
    */
    @Column(name = "stockCode")
    private BigDecimal stockCode;

    /**
    * 担保条件序号
    */
    @Column(name = "ensureType")
    private Integer ensureType;

    /**
    * 担保条件
    */
    @Column(name = "ensure")
    private String ensure;

    /**
    * 所属行业前景
    */
    @Column(name = "vista")
    private String vista;

    /**
    * 未来预计发展规模
    */
    @Column(name = "develop")
    private String develop;

    /**
    * 创建人
    */
    @Column(name = "cuser")
    private Long cuser;

    /**
    * 创建时间
    */
    @Column(name = "cdt")
    private Date cdt;

    /**
    * 修改人
    */
    @Column(name = "muser")
    private Long muser;

    /**
    * 修改时间
    */
    @Column(name = "mdt")
    private Date mdt;

    /**
     *银行流水附件
     */
    @Column(name = "file1")
    private String file1;

    /**
     *财务报表附件
     */
    @Column(name = "file2")
    private String file2;

    /**
     *资金流量表附件
     */
    @Column(name = "file3")
    private String file3;

    /**
     *纳税凭证附件
     */
    @Column(name = "file4")
    private String file4;

    /**
     *股票代码附件
     */
    @Column(name = "file5")
    private String file5;

    /**
     *其它租车目的
     */
    @Column(name = "otherAim")
    private String otherAim;

    /**
     *担保人
     */
    @Column(name = "ensureName")
    private String ensureName;

    private static final long serialVersionUID = 1L;
}
