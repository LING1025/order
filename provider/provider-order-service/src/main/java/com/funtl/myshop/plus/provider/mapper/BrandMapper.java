package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.Brand;
import com.funtl.myshop.plus.provider.domain.BrandNameSelect;
import com.funtl.myshop.plus.provider.domain.ClasenNameSelect;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface BrandMapper extends MyMapper<Brand> {
    List<BrandNameSelect> selectBrandName(@Param("factoryBrandAuto") Long factoryBrandAuto);

    List<ClasenNameSelect> selectClasenName(@Param("brandAuto") Long brandAuto);
}
