package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.OrgCarMapper;
import com.funtl.myshop.plus.provider.domain.OrgCar;
import com.funtl.myshop.plus.provider.api.OrgCarService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class OrgCarServiceImpl implements OrgCarService{

    @Resource
    private OrgCarMapper orgCarMapper;

}
