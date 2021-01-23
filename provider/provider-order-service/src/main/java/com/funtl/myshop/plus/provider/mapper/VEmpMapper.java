package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.CarApplyList;
import com.funtl.myshop.plus.provider.domain.CarApplyOrg;
import com.funtl.myshop.plus.provider.domain.SaleNameSelect;
import com.funtl.myshop.plus.provider.domain.VEmp;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface VEmpMapper extends MyMapper<VEmp> {
    List<SaleNameSelect> selectSaleName(@Param("salesAuto") Long salesAuto, @Param("saleName") String saleName);

    List<CarApplyList> selectCarApply(@Param("orgAuto") Long orgAuto);

    List<CarApplyOrg> selectCarApplyOrg(@Param("userAuto") Long userAuto);
}
