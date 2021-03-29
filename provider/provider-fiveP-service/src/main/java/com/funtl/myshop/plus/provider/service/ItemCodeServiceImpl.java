package com.funtl.myshop.plus.provider.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.ItemCode;
import com.funtl.myshop.plus.provider.mapper.ItemCodeMapper;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
@Service
public class ItemCodeServiceImpl implements ItemCodeService{

    @Resource
    private ItemCodeMapper itemCodeMapper;

}
