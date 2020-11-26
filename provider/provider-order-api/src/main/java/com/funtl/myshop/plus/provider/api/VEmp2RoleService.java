package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.FNameSelect;
import com.funtl.myshop.plus.provider.domain.OrgNameSelect;
import com.funtl.myshop.plus.provider.domain.VEmp2Role;

import java.util.List;

public interface VEmp2RoleService{

    /**
     * 回租报价：承办业代部门下拉选
     * @param userAuto
     * @return
     */
    List<OrgNameSelect> selectOrgName(Long userAuto);

    /**
     * 回租报价：承办业代姓名下拉选（部门序号从业代部门获取）
     * @param roleName
     * @param orgAuto
     * @return
     */
    List<FNameSelect> selectFName(String roleName,Long orgAuto);
}
