package com.funtl.myshop.plus.provider.domain;

import java.io.Serializable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "[v_Emp2Role]")
public class VEmp2Role implements Serializable {
    /**
     *自动生成的UUID
     */
    @Column(name = "UserId")
    private Object userId;

    /**
     *用户序号
     */
    @Column(name = "User_Auto")
    private Long userAuto;

    /**
     *部门序号
     */
    @Column(name = "Org_Auto")
    private Long orgAuto;

    /**
     *部门编码
     */
    @Column(name = "DepCode")
    private String depCode;

    /**
     *等级
     */
    @Column(name = "Lev")
    private Integer lev;

    /**
     *上级单元
     */
    @Column(name = "UpUnit")
    private Long upUnit;

    /**
     *职位等级
     */
    @Column(name = "TitleLevel")
    private Integer titleLevel;

    /**
     *员工序号
     */
    @Column(name = "EmpBase_Auto")
    private Long empBaseAuto;

    /**
     *部门名称
     */
    @Column(name = "DepName")
    private String depName;

    /**
     *职位名称
     */
    @Column(name = "TitleName")
    private String titleName;

    /**
     *员工姓名
     */
    @Column(name = "FName")
    private String fName;

    /**
     *用户名
     */
    @Column(name = "UserName")
    private String username;

    /**
     *状态
     */
    @Column(name = "IsOn")
    private Integer isOn;

    /**
     *角色名
     */
    @Column(name = "RoleName")
    private String roleName;

    private static final long serialVersionUID = 1L;
}
