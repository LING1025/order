package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.domain.TBoxLog;

import java.util.List;

public interface TBoxLogService{

    /**
     * 批量插入设备记录信息
     * @param tBoxLogList
     * @return
     */
    Integer insertList(List<TBoxLog> tBoxLogList);
}
