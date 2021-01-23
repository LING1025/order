package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CarApplyList;
import com.funtl.myshop.plus.provider.domain.CarApplyOrg;
import com.funtl.myshop.plus.provider.domain.SaleNameSelect;
import com.funtl.myshop.plus.provider.domain.VEmp;

import java.util.List;

public interface VEmpService{

    /**
     * 根据userAuto获取业务员、所在部门
     * @param userAuto
     * @return
     */
    VEmp selectByUserAuto(Long userAuto);

    /**
     * 获取业代列表信息
     * @param salesAuto
     * @param saleName
     * @return
     */
    List<SaleNameSelect> selectSaleName(Long salesAuto,String saleName);

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
