package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.OutCheck;
public interface OutCheckService{

    /**
     * 外访签核记录
     * @param outCheck
     * @return
     */
    Long insert(OutCheck outCheck);

}
