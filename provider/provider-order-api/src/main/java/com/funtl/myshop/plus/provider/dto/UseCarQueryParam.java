package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "用车申请：查询参数")
public class UseCarQueryParam implements Serializable {

    private Long carApplicationAuto;

    private String username;

    private String makNo;

    private Date planStartDT;

    private Date planEndDT;

    private String statusN;

    public UseCarQueryParam(Long carApplicationAuto, String username, String makNo, Date planStartDT, Date planEndDT, String statusN) {
        this.carApplicationAuto = carApplicationAuto;
        this.username = username;
        this.makNo = makNo;
        this.planStartDT = planStartDT;
        this.planEndDT = planEndDT;
        this.statusN = statusN;
    }
}
