package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用车请款信息
 */
@Data
@ApiModel(value = "用车请款信息")
public class CarRequest implements Serializable {
    /**
     * 请款人公司别
     */
    @JsonIgnore
    private Long IncAuto;

    @ApiModelProperty(value = "请款人账号")
    private Long requestUser;

    /**
     * 请款类别:ItemType898
     */
    @JsonIgnore
    private Integer requestType=1;//1一般事务

    /**
     * 请款日期
     */
    @JsonIgnore
    private Date requestDT;

    /**
     * 请款金额(发票金额)
     */
    @ApiModelProperty(value = "请款金额(发票金额)")
    private BigDecimal requestAmt;

    @JsonIgnore
    private Integer status=10;//10送件中

    /**
     * 是否暂借(0:不1:是)
     */
    @JsonIgnore
    private Integer isZJ=0;

    /**
     * 暂借金额
     */
    @JsonIgnore
    private BigDecimal zJAmt=BigDecimal.valueOf(0);

    /**
     * 实际请款金额(请款总金额-暂借款金额)
     */
    @JsonIgnore
    private BigDecimal payRequestAmt;

    /**
     * 暂借付款别
     */
    @JsonIgnore
    private Integer zjPayType=0;

    /**
     * 付款别:ItemType899
     */
    @ApiModelProperty(value = "付款别:1现金 2转账支票 3现金支票 4网银")
    private Integer payType;

    /**
     * 网银::ItemType897
     */
    @ApiModelProperty(value = "网银:1中行 2建行 3星展 4瑞穗 5其他")
    private Integer cyBerBankType=0;
}
