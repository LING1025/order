package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.commons.utils.PageInfoUtils;
import com.funtl.myshop.plus.provider.domain.SelfAgentList;
import com.funtl.myshop.plus.provider.dto.SelfAgentListDto;
import com.funtl.myshop.plus.provider.mapper.CreditAgentMapper;
import com.funtl.myshop.plus.provider.api.CreditAgentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class CreditAgentServiceImpl implements CreditAgentService{

    @Resource
    private CreditAgentMapper creditAgentMapper;

    @Override
    public PageInfo<SelfAgentListDto> selectSelf(Long selfUser, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<SelfAgentList> pageInfo = new PageInfo<>(creditAgentMapper.selectSelf(selfUser));
        PageInfo<SelfAgentListDto> result = PageInfoUtils.pageInfo2PageInfoDTO(pageInfo,SelfAgentListDto.class);
        return result;
    }

    @Override
    public PageInfo<SelfAgentListDto> selectAgent(Long agentUser, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<SelfAgentList> pageInfo = new PageInfo<>(creditAgentMapper.selectAgent(agentUser));
        PageInfo<SelfAgentListDto> result = PageInfoUtils.pageInfo2PageInfoDTO(pageInfo,SelfAgentListDto.class);
        return result;
    }
}
