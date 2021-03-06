package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.AgentList;
import com.funtl.myshop.plus.provider.domain.CarApplyList;
import com.funtl.myshop.plus.provider.domain.CarApplyOrg;
import com.funtl.myshop.plus.provider.domain.VEmp;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface VEmpMapper extends MyMapper<VEmp> {
    List<CarApplyList> selectCarApply(@Param("orgAuto") Long orgAuto,@Param("userAuto") Long userAuto);

    List<CarApplyOrg> selectCarApplyOrg(@Param("userAuto") Long userAuto);

    List<AgentList> selectAgentList(@Param("agentUser") Long agentUser);
}
