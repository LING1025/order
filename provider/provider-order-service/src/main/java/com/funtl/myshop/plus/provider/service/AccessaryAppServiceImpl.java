package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.CheckDetailList;
import com.funtl.myshop.plus.provider.mapper.AccessaryAppMapper;
import com.funtl.myshop.plus.provider.domain.AccessaryApp;
import com.funtl.myshop.plus.provider.api.AccessaryAppService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class AccessaryAppServiceImpl implements AccessaryAppService{

    @Resource
    private AccessaryAppMapper accessaryAppMapper;


    @Override
    public List<CheckDetailList> selectCheckDetailList(Long requestAuto) {
        return accessaryAppMapper.selectCheckDetailList(requestAuto);
    }
}
