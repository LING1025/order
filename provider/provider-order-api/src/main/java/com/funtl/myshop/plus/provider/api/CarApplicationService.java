package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CarApplication;
import com.funtl.myshop.plus.provider.domain.UseCarDoc;
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

    /**
     * 获取用车申请：签核明细数据
     * @param carApplicationAuto
     * @return
     */
    List<UseCarDoc> selectUseCarDoc(Long carApplicationAuto);
}
