package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.domain.*;

import javax.annotation.Resource;

import com.funtl.myshop.plus.provider.mapper.ItemCodeMapper;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class ItemCodeServiceImpl implements ItemCodeService{

    @Resource
    private ItemCodeMapper itemCodeMapper;

    @Override
    public List<TypeNameList> selectByItemType(Integer itemType) {
        return itemCodeMapper.selectByItemType(itemType);
    }

    @Override
    public List<IncNameList> selectIncNameList(String incName) {
        return itemCodeMapper.selectIncNameList(incName);
    }

    @Override
    public List<AccountNameList> selectAccountNameList(Long incAuto,Long accountAuto) {
        return itemCodeMapper.selectAccountNameList(incAuto,accountAuto);
    }

    @Override
    public List<LicensePlateList> selectLicense(Integer insureAddr, Integer type) {
        return itemCodeMapper.selectLicense(insureAddr,type);
    }
}
