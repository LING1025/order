package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.OutBound;
public interface OutBoundService{

    /**
     * 外访客户新增数据
     * @param outBound
     * @return
     */
    Long insert(OutBound outBound);

}
