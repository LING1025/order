package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.SelfAgentList;
import com.funtl.myshop.plus.provider.mapper.CreditAgentMapper;
import com.funtl.myshop.plus.provider.api.CreditAgentService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class CreditAgentServiceImpl implements CreditAgentService{

    @Resource
    private CreditAgentMapper creditAgentMapper;

    @Override
    public List<SelfAgentList> selectSelf(Long selfUser) {
        return creditAgentMapper.selectSelf(selfUser);
    }

    @Override
    public List<SelfAgentList> selectAgent(Long agentUser) {
        return creditAgentMapper.selectAgent(agentUser);
    }
}