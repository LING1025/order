package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.Brand;
import com.funtl.myshop.plus.provider.domain.BrandNameSelect;
import com.funtl.myshop.plus.provider.domain.ClasenNameSelect;

import java.util.List;

public interface BrandService{

    /**
     * 回租报价：2、厂牌下拉选(依总厂牌序号获取厂牌)
     * @param factoryBrandAuto
     * @return
     */
    List<BrandNameSelect> selectBrandName(Long factoryBrandAuto);

    /**
     * 回租报价：3、车型下拉选(依厂牌序号获取车型号)
     * @param brandAuto
     * @return
     */
    List<ClasenNameSelect> selectClasenName(Long brandAuto);
}
