package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.BankList;
import com.funtl.myshop.plus.provider.domain.PurchaseFeeList;
import com.funtl.myshop.plus.provider.domain.PurchaseRequest;
import com.funtl.myshop.plus.provider.domain.RequestInc;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface PurchaseRequestMapper extends MyMapper<PurchaseRequest> {

    RequestInc selectInc(@Param("userAuto") Long userAuto);

    List<PurchaseFeeList> selectPurchaseFeeList(@Param("requestUser") Long requestUser, @Param("carApplicationAuto") Long carApplicationAuto);

    /*获取银行别下拉选数据*/
    List<BankList> selectBank(@Param("bankNameT") String bankNameT);
}
