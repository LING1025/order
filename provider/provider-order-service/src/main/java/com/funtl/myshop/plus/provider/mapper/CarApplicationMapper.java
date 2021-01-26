package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.CarApplication;
import com.funtl.myshop.plus.provider.domain.UseCarDoc;
import com.funtl.myshop.plus.provider.domain.UserCarList;
import com.funtl.myshop.plus.provider.dto.UseCarQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface CarApplicationMapper extends MyMapper<CarApplication> {
    List<UserCarList> selectUserCar(@Param("param") UseCarQueryParam useCarQueryParam);

    List<UseCarDoc> selectUseCarDoc(@Param("carApplicationAuto") Long carApplicationAuto);
}
