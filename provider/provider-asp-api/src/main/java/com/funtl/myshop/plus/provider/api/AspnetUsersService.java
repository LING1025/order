package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AspnetUsers;
import com.funtl.myshop.plus.provider.dto.RoleList;

import java.util.List;

public interface AspnetUsersService{
    /**
     * 根据用户id获取选择权限数据
     * @param userAuto
     * @return
     */
    List<RoleList> selectByUserAuto(Long userAuto);

    /**
     * 选择操作人：代理人需要使用的
     * @param applicationId
     * @return
     */
    AspnetUsers selectByAppId(Object applicationId,Object userId);
}
