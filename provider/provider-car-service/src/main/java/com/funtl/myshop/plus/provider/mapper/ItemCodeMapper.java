package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.CarAreaList;
import com.funtl.myshop.plus.provider.domain.ItemCode;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface ItemCodeMapper extends MyMapper<ItemCode> {

    List<CarAreaList> selectCarArea(Integer itemType);
}
