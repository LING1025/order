package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.mapper.TradeItemMapper;
import com.funtl.myshop.plus.provider.domain.TradeItem;
import com.funtl.myshop.plus.provider.api.TradeItemService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class TradeItemServiceImpl implements TradeItemService{

    @Resource
    private TradeItemMapper tradeItemMapper;

}
