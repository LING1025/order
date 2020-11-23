package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "上牌费请款：暂借明细数据")
public class ZjDetail implements Serializable {
    @ApiModelProperty(value = "暂借类别")
    private String zjTypeD;

    @ApiModelProperty(value = "厂商名称")
    private String payeeName;

    @ApiModelProperty(value = "暂借状态")
    private String statusD;

    @ApiModelProperty(value = "暂借来源")
    private String isAppropriationD;

    @ApiModelProperty(value = "拨款日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date exportDT;

    @ApiModelProperty(value = "暂借金额")
    private BigDecimal zJAmt;

    @ApiModelProperty(value = "销账金额")
    private BigDecimal xZAmt;

    @ApiModelProperty(value = "请款金额")
    private BigDecimal requestAmt;

    @ApiModelProperty(value = "判断有没销账，是否显示销账按钮：0否 1是")
    private Integer isShow;
}
