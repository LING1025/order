package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.domain.UserCarList;
import com.funtl.myshop.plus.provider.dto.UseCarQueryParam;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.CarApplication;
import com.funtl.myshop.plus.provider.mapper.CarApplicationMapper;
import com.funtl.myshop.plus.provider.api.CarApplicationService;

import java.util.List;

@Service
public class CarApplicationServiceImpl implements CarApplicationService{

    @Resource
    private CarApplicationMapper carApplicationMapper;


    @Override
    public List<UserCarList> selectUserCar(UseCarQueryParam useCarQueryParam) {
        return carApplicationMapper.selectUserCar(useCarQueryParam);
    }
}
