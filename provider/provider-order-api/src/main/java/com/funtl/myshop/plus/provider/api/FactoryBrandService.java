package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.FactoryBrand;
import com.funtl.myshop.plus.provider.domain.FactoryBrandNameSelect;

import java.util.List;

public interface FactoryBrandService{

    /**
     * 回租报价：总厂牌下拉选
     * @return
     */
    List<FactoryBrandNameSelect> selectFactoryBrandName();

}
