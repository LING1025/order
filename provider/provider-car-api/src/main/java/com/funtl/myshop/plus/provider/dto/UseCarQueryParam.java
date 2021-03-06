package com.funtl.myshop.plus.provider.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用车申请：查询参数")
public class UseCarQueryParam implements Serializable {

    private Long carApplicationAuto;

    /**
     * 申请人序号
     */
    private Long appUser;

    private String username;

    private String makNo;

    @JsonFormat(pattern = "yyyy-MM-dd")//把时间类型 转换成JSON格式类型，前提取出进行展示
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")//会把字符串类型 按照格式yyyy-MM-dd HH:mm:ss 转换成时间类型
    private String planStartDT;

//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String planEndDT;

    private String statusN;

    public UseCarQueryParam(Long carApplicationAuto, Long appUser, String username, String makNo, String planStartDT, String planEndDT, String statusN) {
        this.carApplicationAuto = carApplicationAuto;
        this.appUser = appUser;
        this.username = username;
        this.makNo = makNo;
        this.planStartDT = planStartDT;
        this.planEndDT = planEndDT;
        this.statusN = statusN;
    }
}
