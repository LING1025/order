package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.IncNameList;
import com.funtl.myshop.plus.provider.domain.ItemCode;
import com.funtl.myshop.plus.provider.domain.TypeNameList;

import java.util.List;

public interface ItemCodeService{
    /**
     * 根据编号获取类别列表
     * @param itemType
     * @return
     */
    List<TypeNameList> selectByItemType(Integer itemType);

    /**
     *公司别下拉选
     * @param incName
     * @return
     */
    List<IncNameList> selectIncNameList(String incName);
}
