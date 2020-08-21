package com.funtl.myshop.plus.provider.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class RoleList implements Serializable {
    private Long rolesAuto;

    private String roleName;

    private Long num;

    /*@JsonIgnore
    private String itemName;

    @JsonIgnore
    private Integer seq;*/
}
