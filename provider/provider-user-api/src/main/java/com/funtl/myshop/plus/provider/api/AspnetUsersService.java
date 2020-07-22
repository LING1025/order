package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AspnetUsers;
public interface AspnetUsersService{
    /**
     * 获取用户
     * @param username 用户名
     * @return
     */
    AspnetUsers get(String username);

}
