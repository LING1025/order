package com.funtl.myshop.plus.provider.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClientCheckDto implements Serializable {
    private Long rptVstFlowAuto;

    private String memo;

    private Integer userAuto;

    private Integer isAgent;
}
