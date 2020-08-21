package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.dto.RoleList;

import java.util.List;

public interface AspnetUsersService{
    /**
     * 根据用户id获取选择权限数据
     * @param userAuto
     * @return
     */
    List<RoleList> selectByUserAuto(Long userAuto);
}
