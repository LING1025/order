package com.funtl.myshop.plus.provider.mapper;


import com.funtl.myshop.plus.provider.domain.AgentList;
import com.funtl.myshop.plus.provider.domain.CreditAgent;
import com.funtl.myshop.plus.provider.domain.SelfAgentList;
import com.funtl.myshop.plus.provider.domain.SelfList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface CreditAgentMapper extends MyMapper<CreditAgent> {
    List<SelfAgentList> selectSelf(@Param("selfUser") Long selfUser);

    List<SelfAgentList> selectAgent(@Param("agentUser") Long agentUser);

    List<AgentList> selectAgentList(@Param("agentUser") Long agentUser);

}
