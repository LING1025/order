package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.WxEncryptedData;

public interface WxEncryptedDataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WxEncryptedData record);

    int insertSelective(WxEncryptedData record);

    WxEncryptedData selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WxEncryptedData record);

    int updateByPrimaryKey(WxEncryptedData record);
}