package com.funtl.myshop.plus.business.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "付款日修改审核：核准、驳回")
public class OrdersPayParamDto implements Serializable {
    @ApiModelProperty(value = "授信单号")
    private Long creditMainAuto;

    @ApiModelProperty(value = "序号")
    private Integer appSeq;

    @ApiModelProperty(value = "签核意见")
    private String creditMemo;

    /**
     * (UserID != LoginUserID) ? 1 : 0)--操作人类别：1别人 0本人--通过id判断给type赋值
     */
    @JsonIgnore
    private Integer type;

    @ApiModelProperty(value = "操作人")
    private Long userAuto;

    @ApiModelProperty(value = "登录人")
    private Long loginUserAuto;

    @ApiModelProperty(value = "状态：20核准 5驳回")
    private Integer status;
}
