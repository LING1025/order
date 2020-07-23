package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.CreditAgent;
import com.funtl.myshop.plus.provider.dto.SelfAgentListDto;
import com.github.pagehelper.PageInfo;

public interface CreditAgentService{
    /**
     * 根据本人姓名获取代理数据
     * @param selfUser
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SelfAgentListDto> selectSelf(Long selfUser, Integer pageNum, Integer pageSize);

    /**
     * 根据代理人姓名获取代理数据
     * @param agentUser
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<SelfAgentListDto> selectAgent(Long agentUser, Integer pageNum, Integer pageSize);

}
