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
@ApiModel(value = "车辆归还：用车费用请款数据")
public class UserCarRequestParamDto implements Serializable {
    @ApiModelProperty(value = "发票号码")
    private String invoiceNumber;

    @ApiModelProperty(value = "请款人序号")
    private Long requestUser=0L;

    @ApiModelProperty(value = "请款金额(发票金额)")
    private BigDecimal requestAmt;

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

    @ApiModelProperty(value = "费用明细")
    private String purchaseRemark;

    @ApiModelProperty(value = "费用别序号：1过路费 2停车费 3加油费 40充电费(汽车)")
    private Integer feeType;

    @ApiModelProperty(value = "费用别")
    private String feeTypeName;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

    @ApiModelProperty(value = "费用时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date feeTime;

    @ApiModelProperty(value = "附件图片")
    private String img;

    /**
     * 创建人
     */
    @JsonIgnore
    private Long cuser;

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date cdt;
}
