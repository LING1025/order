package com.funtl.myshop.plus.provider.service;

import javax.annotation.Resource;
import com.funtl.myshop.plus.provider.domain.ItemCode;
import com.funtl.myshop.plus.provider.domain.ItemNameList;
import com.funtl.myshop.plus.provider.domain.LeasebackSelect;
import com.funtl.myshop.plus.provider.dto.RoleList;
import com.funtl.myshop.plus.provider.mapper.ItemCodeMapper;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class ItemCodeServiceImpl implements ItemCodeService{

    @Resource
    private ItemCodeMapper itemCodeMapper;

    @Override
    public List<RoleList> selectByType(Integer itemType) {
        return itemCodeMapper.selectByType(itemType);
    }

    @Override
    public List<LeasebackSelect> selectItemName(Integer itemType,Long num) {
        return itemCodeMapper.selectItemName(itemType,num);
    }

}
