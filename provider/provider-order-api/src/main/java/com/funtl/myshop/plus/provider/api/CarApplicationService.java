package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CarApplication;
import com.funtl.myshop.plus.provider.domain.UserCarList;
import com.funtl.myshop.plus.provider.dto.UseCarQueryParam;

import java.util.List;

public interface CarApplicationService{

    /**
     * 获取用车申请：申请列表数据
     * @param useCarQueryParam
     * @return
     */
    List<UserCarList> selectUserCar(UseCarQueryParam useCarQueryParam);

}
