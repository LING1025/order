package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AspnetRoles;

import java.util.List;

public interface AspnetRolesService{
    /**
     * 根据UserId获取角色信息
     * @param userId
     * @return
     */
    List<AspnetRoles> selectByUserId(Object userId);

    AspnetRoles selectByRoleAuto(Integer rolesAuto);

}
