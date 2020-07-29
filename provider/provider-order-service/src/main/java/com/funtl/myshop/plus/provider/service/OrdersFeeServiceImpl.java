package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.OrdersFee;
import com.funtl.myshop.plus.provider.mapper.OrdersFeeMapper;
import com.funtl.myshop.plus.provider.api.OrdersFeeService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class OrdersFeeServiceImpl implements OrdersFeeService{

    @Resource
    private OrdersFeeMapper ordersFeeMapper;


}
