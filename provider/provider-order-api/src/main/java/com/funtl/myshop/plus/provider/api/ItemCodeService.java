package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ItemCode;

import com.funtl.myshop.plus.provider.domain.ItemNameList;
import com.funtl.myshop.plus.provider.dto.RoleList;
import java.util.List;

public interface ItemCodeService{

    /**
     * 根据用户id获取选择权限数据用到的api
     * @param itemType
     * @return
     */
    List<RoleList> selectByType(Integer itemType);

    /**
     * 根据案件类型获取项目名1
     * @param itemType
     * @return
     */
    List<ItemNameList> selectItemName1(Integer itemType);

    /**
     * 根据案件类型获取项目名2
     * @param itemType
     * @return
     */
    List<ItemNameList> selectItemName2(Integer itemType);
}
