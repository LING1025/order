package com.funtl.myshop.plus.provider.mapper;


import com.funtl.myshop.plus.provider.domain.AgentList;
import com.funtl.myshop.plus.provider.domain.CreditAgent;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface CreditAgentMapper extends MyMapper<CreditAgent> {

    List<AgentList> selectAgentList(@Param("agentUser") Long agentUser);
}
