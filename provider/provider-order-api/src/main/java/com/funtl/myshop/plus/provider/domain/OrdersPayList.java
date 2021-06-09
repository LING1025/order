package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "付款日修改审核：列表数据")
public class OrdersPayList implements Serializable {
    @ApiModelProperty(value = "部分")
    private String depName;

    @ApiModelProperty(value = "业代")
    private String saleName;

    @ApiModelProperty(value = "客户名称")
    private String cusName;

//    @ApiModelProperty(value = "序号")
    /**
     * 序号
     */
    @JsonIgnore
    private Integer appSeq;

//    @ApiModelProperty(value = "角色ID")
    /**
     * 角色ID
     */
    @JsonIgnore
    private Integer roleId;

//    @ApiModelProperty(value = "业务类别序号")
    /**
     * 业务类别序号
     */
    @JsonIgnore
    private Integer orderType;

    @ApiModelProperty(value = "客户评等")
    private String creditLevelName;

    @ApiModelProperty(value = "付款日")
    private Date payDay;

    @ApiModelProperty(value = "修改说明")
    private String payDayMemo;

//    @ApiModelProperty(value = "授信单号")
    /**
     * 授信单号
     */
    @JsonIgnore
    private Long creditMainAuto;

//    @ApiModelProperty(value = "试算单号")
    /**
     * 试算单号
     */
    @JsonIgnore
    private Long ordersAuto;
}
