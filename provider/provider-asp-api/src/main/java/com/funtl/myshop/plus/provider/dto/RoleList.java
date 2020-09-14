package com.funtl.myshop.plus.provider.dto;

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
