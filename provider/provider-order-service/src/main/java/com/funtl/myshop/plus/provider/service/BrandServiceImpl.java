package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.BrandMapper;
import com.funtl.myshop.plus.provider.domain.Brand;
import com.funtl.myshop.plus.provider.api.BrandService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class BrandServiceImpl implements BrandService{

    @Resource
    private BrandMapper brandMapper;


}
