package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.PurchaseRRFlow;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

public interface PurchaseRRFlowMapper extends MyMapper<PurchaseRRFlow> {
    Integer flowInsert(@Param("purchaseRequestAuto") Long purchaseRequestAuto, @Param("requestUser") Long requestUser);

    Integer deleteByRrAuto(@Param("rrAuto") Long rrAuto);
}
