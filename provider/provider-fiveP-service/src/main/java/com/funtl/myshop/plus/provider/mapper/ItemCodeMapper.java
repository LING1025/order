package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.*;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface ItemCodeMapper extends MyMapper<ItemCode> {
    /*根据编号获取类别列表*/
    List<TypeNameList> selectByItemType(@Param("itemType") Integer itemType);

    /*公司别下拉选*/
    List<IncNameList> selectIncNameList(@Param("incName") String incName);

    /*根据进款公司别序号获取进款账号*/
    List<AccountNameList> selectAccountNameList(@Param("incAuto") Long incAuto,@Param("accountAuto") Long accountAuto);

    /*拨款申请作业：出保单地下拉选*/
    List<LicensePlateList> selectLicense(@Param("insureAddr") Integer insureAddr,@Param("type") Integer type);
}
