package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.SaleOpenIdList;
import com.funtl.myshop.plus.provider.domain.WxEncryptedData;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface WxEncryptedDataMapper extends MyMapper<WxEncryptedData> {
    List<SaleOpenIdList> selectSaleOpenId(@Param("salesAuto") Long salesAuto);
}
