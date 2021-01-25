package com.funtl.myshop.plus.provider.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.CarApplication;
import com.funtl.myshop.plus.provider.mapper.CarApplicationMapper;
import com.funtl.myshop.plus.provider.api.CarApplicationService;
@Service
public class CarApplicationServiceImpl implements CarApplicationService{

    @Resource
    private CarApplicationMapper carApplicationMapper;


}
