package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.TelEmail;
import com.funtl.myshop.plus.provider.domain.VEmp;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

public interface VEmpMapper extends MyMapper<VEmp> {
    TelEmail selectTelEM(@Param("type") String type, @Param("userAuto") Long userAuto);
}
