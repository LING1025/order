package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.LKRQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface PurchaseRequestMapper extends MyMapper<PurchaseRequest> {

    RequestInc selectInc(@Param("userAuto") Long userAuto);

    List<PurchaseFeeList> selectPurchaseFeeList(@Param("requestUser") Long requestUser, @Param("carApplicationAuto") Long carApplicationAuto);

    /*获取银行别下拉选数据*/
    List<BankList> selectBank(@Param("bankNameT") String bankNameT);

    /*领款人搜索*/
    List<LKRList> selectLKR(@Param("lkrQueryParam") LKRQueryParam lkrQueryParam);
}
