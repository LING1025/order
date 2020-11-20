package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "讯息列表数据")
public class MessageList implements Serializable {
    @ApiModelProperty(value = "请款单号")
    private Long ordersFeeRequestAuto;

    @ApiModelProperty(value = "申购单号")
    private Long orderAuto;

    @ApiModelProperty(value = "公司别")
    private String incName;

    @ApiModelProperty(value = "客户名称")
    private String cusName;

    @ApiModelProperty(value = "车牌号")
    private String makNo;

    @ApiModelProperty(value = "车型")
    private String clasenName;

    @ApiModelProperty(value = "业代")
    private String salesName;

    @ApiModelProperty(value = "试算上牌费金额")
    private BigDecimal ordersFeeAmt;

    @ApiModelProperty(value = "请款日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date requestDT;

    @ApiModelProperty(value = "请款金额")
    private BigDecimal requestAmt;

    @ApiModelProperty(value = "暂借金额")
    private BigDecimal zJAmt;

    @ApiModelProperty(value = "销账金额")
    private BigDecimal xZAmt;

    @JsonIgnore
    private Integer status;

    @ApiModelProperty(value = "状态")
    private String statusD;

    @ApiModelProperty(value = "业绩日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date yjcDT;

    @JsonIgnore
    private Integer type;

    @ApiModelProperty(value = "类别")
    private String typeD;

    @ApiModelProperty(value = "送签 0否 1是 ")
    private Integer ckb;

    /*@ApiModelProperty(value = "车架号")
    private String carNO;

    @ApiModelProperty(value = "领牌日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date makDT;

    @ApiModelProperty(value = "请款备注")
    private String remark;*/
}
