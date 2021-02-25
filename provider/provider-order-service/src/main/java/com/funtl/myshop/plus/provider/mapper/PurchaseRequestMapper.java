package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.PurchaseRequest;
import com.funtl.myshop.plus.provider.domain.RequestInc;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

public interface PurchaseRequestMapper extends MyMapper<PurchaseRequest> {

    RequestInc selectInc(@Param("userAuto") Long userAuto);
}
