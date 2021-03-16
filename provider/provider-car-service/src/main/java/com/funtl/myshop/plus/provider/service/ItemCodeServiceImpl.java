package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.domain.CarAreaList;
import com.funtl.myshop.plus.provider.domain.ItemCode;
import com.funtl.myshop.plus.provider.mapper.ItemCodeMapper;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class ItemCodeServiceImpl implements ItemCodeService{

    @Resource
    private ItemCodeMapper itemCodeMapper;


    @Override
    public List<CarAreaList> selectCarArea(Integer itemType) {
        return itemCodeMapper.selectCarArea(itemType);
    }
}
