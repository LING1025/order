package com.funtl.myshop.plus.provider.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "用车申请：查询参数")
public class UseCarQueryParam implements Serializable {

    private Long carApplicationAuto;

    private String username;

    private String makNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")//把时间类型 转换成JSON格式类型，前提取出进行展示
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")//会把字符串类型 按照格式yyyy-MM-dd HH:mm:ss 转换成时间类型
    private String planStartDT;

//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private String planEndDT;

    private Integer status;

    public UseCarQueryParam(Long carApplicationAuto, String username, String makNo, String planStartDT, String planEndDT, Integer status) {
        this.carApplicationAuto = carApplicationAuto;
        this.username = username;
        this.makNo = makNo;
        this.planStartDT = planStartDT;
        this.planEndDT = planEndDT;
        this.status = status;
    }
}
