package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AgentList;
import com.funtl.myshop.plus.provider.domain.SelfAgentList;
import com.funtl.myshop.plus.provider.domain.SelfList;

import java.util.List;

public interface CreditAgentService{
    List<AgentList> selectAgentList(Long agentUser);

}
