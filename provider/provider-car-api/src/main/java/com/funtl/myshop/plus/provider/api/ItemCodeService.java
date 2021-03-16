package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CarAreaList;
import com.funtl.myshop.plus.provider.domain.ItemCode;

import java.util.List;

public interface ItemCodeService{

    /**
     * 根据itemType获取用车类别、牌照地区、车辆选择、事由说明
     * @param itemType
     * @return
     */
    List<CarAreaList> selectCarArea(Integer itemType);

}
