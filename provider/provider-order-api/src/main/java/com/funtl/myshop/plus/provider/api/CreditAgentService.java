package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AgentList;
import com.funtl.myshop.plus.provider.domain.SelfAgentList;
import com.funtl.myshop.plus.provider.domain.SelfList;

import java.util.List;

public interface CreditAgentService{
    /**
     * 根据本人姓名获取代理数据
     * @param selfUser
     * @return
     */
    List<SelfAgentList> selectSelf(Long selfUser);

    /**
     * 根据代理人姓名获取代理数据
     * @param agentUser
     * @return
     */
    List<SelfAgentList> selectAgent(Long agentUser);

    List<AgentList> selectAgentList(Long agentUser);

}
