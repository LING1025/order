package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.FactoryBrand;
import com.funtl.myshop.plus.provider.domain.FactoryBrandNameSelect;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface FactoryBrandMapper extends MyMapper<FactoryBrand> {
    List<FactoryBrandNameSelect> selectFactoryBrandName();
}
