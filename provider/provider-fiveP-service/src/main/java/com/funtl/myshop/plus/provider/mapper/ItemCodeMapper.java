package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.ItemCode;
import com.funtl.myshop.plus.provider.domain.TypeNameList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface ItemCodeMapper extends MyMapper<ItemCode> {
    List<TypeNameList> selectByItemType(@Param("itemType") Integer itemType);
}
