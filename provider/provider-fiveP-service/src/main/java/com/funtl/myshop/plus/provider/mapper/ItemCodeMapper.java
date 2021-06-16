package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.IncNameList;
import com.funtl.myshop.plus.provider.domain.ItemCode;
import com.funtl.myshop.plus.provider.domain.TypeNameList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface ItemCodeMapper extends MyMapper<ItemCode> {
    /*根据编号获取类别列表*/
    List<TypeNameList> selectByItemType(@Param("itemType") Integer itemType);

    /*公司别下拉选*/
    List<IncNameList> selectIncNameList(@Param("incName") String incName);
}
