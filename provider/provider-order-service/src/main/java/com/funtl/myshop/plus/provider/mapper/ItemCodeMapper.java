package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.ItemCode;
import com.funtl.myshop.plus.provider.dto.RoleList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface ItemCodeMapper extends MyMapper<ItemCode> {
    List<RoleList> selectByType(@Param("itemType") Integer itemType);
}
