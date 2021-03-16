package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AgentList;

import java.util.List;

public interface CreditAgentService{
    /**
     * 代理人
     * @param agentUser
     * @return
     */
    List<AgentList> selectAgentList(Long agentUser);

}
