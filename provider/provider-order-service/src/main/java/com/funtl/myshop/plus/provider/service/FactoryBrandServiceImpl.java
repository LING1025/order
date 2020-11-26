package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.FactoryBrandMapper;
import com.funtl.myshop.plus.provider.domain.FactoryBrand;
import com.funtl.myshop.plus.provider.api.FactoryBrandService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class FactoryBrandServiceImpl implements FactoryBrandService{

    @Resource
    private FactoryBrandMapper factoryBrandMapper;


}
