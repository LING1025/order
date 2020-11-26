package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.FNameSelect;
import com.funtl.myshop.plus.provider.domain.OrgNameSelect;
import com.funtl.myshop.plus.provider.domain.VEmp2Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface VEmp2RoleMapper extends MyMapper<VEmp2Role> {
    List<OrgNameSelect> selectOrgName(@Param("userAuto") Long userAuto);

    List<FNameSelect> selectFName(@Param("roleName") String roleName, @Param("orgAuto") Long orgAuto);
}
