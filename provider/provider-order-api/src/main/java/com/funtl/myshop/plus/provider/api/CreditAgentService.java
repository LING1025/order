package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AgentList;

import java.util.List;

public interface CreditAgentService{
    List<AgentList> selectAgentList(Long agentUser);

}
