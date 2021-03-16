package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CarApplyList;
import com.funtl.myshop.plus.provider.domain.CarApplyOrg;
import com.funtl.myshop.plus.provider.domain.VEmp;

import java.util.List;

public interface VEmpService{

    /**
     * 获取使用人数据
     * @param orgAuto
     * @return
     */
    List<CarApplyList> selectCarApply(Long orgAuto);

    /**
     * 获取使用部门数据
     * @param userAuto
     * @return
     */
    List<CarApplyOrg> selectCarApplyOrg(Long userAuto);

}
