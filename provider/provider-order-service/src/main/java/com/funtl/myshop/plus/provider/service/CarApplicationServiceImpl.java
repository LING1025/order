package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.domain.UseCarDoc;
import com.funtl.myshop.plus.provider.domain.UserCarList;
import com.funtl.myshop.plus.provider.dto.UseCarQueryParam;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.CarApplicationMapper;
import com.funtl.myshop.plus.provider.api.CarApplicationService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class CarApplicationServiceImpl implements CarApplicationService{

    @Resource
    private CarApplicationMapper carApplicationMapper;


    @Override
    public List<UserCarList> selectUserCar(UseCarQueryParam useCarQueryParam) {
        return carApplicationMapper.selectUserCar(useCarQueryParam);
    }

    @Override
    public List<UseCarDoc> selectUseCarDoc(Long carApplicationAuto) {
        return carApplicationMapper.selectUseCarDoc(carApplicationAuto);
    }
}
