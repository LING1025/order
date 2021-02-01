package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.OrgCar;
import com.funtl.myshop.plus.provider.domain.OrgCarList;
import com.funtl.myshop.plus.provider.dto.OrgCarQueryParam;

import java.util.List;

public interface OrgCarService{

    /**
     * 用车申请：自动配车、用车审核：获取车辆列表
     * @param orgCarQueryParam
     * @return
     */
    List<OrgCarList> selectOrgCar(OrgCarQueryParam orgCarQueryParam);

}
