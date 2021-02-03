package com.funtl.myshop.plus.provider.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用车审核：查询参数")
public class CheckQueryParam implements Serializable {
    /**
     * 操作人userAuto
     */
    private Long loginAuto;

    private Long carApplicationAuto;

    private String username;

    private String appUserN;

    private String makNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")//把时间类型 转换成JSON格式类型，前提取出进行展示
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")//会把字符串类型 按照格式yyyy-MM-dd HH:mm:ss 转换成时间类型
    private String planStartDT;

    //    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private String planEndDT;

    private String statusN;

    public CheckQueryParam(Long loginAuto, Long carApplicationAuto, String username, String appUserN, String makNo, String planStartDT, String planEndDT, String statusN) {
        this.loginAuto = loginAuto;
        this.carApplicationAuto = carApplicationAuto;
        this.username = username;
        this.appUserN = appUserN;
        this.makNo = makNo;
        this.planStartDT = planStartDT;
        this.planEndDT = planEndDT;
        this.statusN = statusN;
    }
}
