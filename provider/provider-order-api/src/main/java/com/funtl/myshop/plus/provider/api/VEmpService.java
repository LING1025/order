package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.TelEmail;
import com.funtl.myshop.plus.provider.domain.VEmp;
public interface VEmpService{

    /**
     * 根据userAuto获取业务员、所在部门
     * @param userAuto
     * @return
     */
    VEmp selectByUserAuto(Long userAuto);

    /**
     * 以用户ID查询用户名、手机号、邮箱，type默认'R4'
     * @param type
     * @param userAuto
     * @return
     */
    TelEmail selectTelEM(String type,Long userAuto);
}
