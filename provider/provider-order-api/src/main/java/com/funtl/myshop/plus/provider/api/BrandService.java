package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Brand;
import com.funtl.myshop.plus.provider.domain.BrandNameSelect;

import java.util.List;

public interface BrandService{

    /**
     * 回租报价：2、厂牌下拉选
     * @param factoryBrandAuto
     * @return
     */
    List<BrandNameSelect> selectBrandName(Long factoryBrandAuto);

}
