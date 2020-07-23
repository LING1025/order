package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "[aspnet_Roles]")
public class AspnetRoles implements Serializable {
    @Column(name = "RoleId")
    private Object roleId;

    @Column(name = "ApplicationId")
    private Object applicationId;

    /**
     * 角色名
     */
    @Column(name = "RoleName")
    private String roleName;

    /**
     * 小写角色名
     */
    @Column(name = "LoweredRoleName")
    private String loweredRoleName;

    /**
     * 描述
     */
    @Column(name = "Description")
    private String description;

    /**
     * 角色id
     */
    @Id
    @Column(name = "Roles_Auto")
    private Long rolesAuto;

    /**
     * 等级
     */
    @Column(name = "TitleLevel")
    private Integer titleLevel;

    @Column(name = "Org_Auto")
    private Integer orgAuto;

    private static final long serialVersionUID = 1L;
}
