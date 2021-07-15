package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.*;

import java.util.List;

public interface ItemCodeService{
    /**
     * 根据编号获取类别列表
     * @param itemType
     * @return
     */
    List<TypeNameList> selectByItemType(Integer itemType);

    /**
     *公司别下拉选
     * @param incName
     * @return
     */
    List<IncNameList> selectIncNameList(String incName);

    /**
     * 根据进款公司别序号获取进款账号
     * @param incAuto
     * @return
     */
    List<AccountNameList> selectAccountNameList(Long incAuto,Long accountAuto);

    /**
     * 拨款申请作业：出保单地下拉选
     * @param insureAddr
     * @return
     */
    List<LicensePlateList> selectLicense(Integer insureAddr, Integer type);
}
