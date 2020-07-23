package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.VEmp;
public interface VEmpService{

    /**
     * 根据userAuto获取业务员、所在部门
     * @param userAuto
     * @return
     */
    VEmp selectByUserAuto(Long userAuto);

}
