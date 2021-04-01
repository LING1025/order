package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.OutCheck;
import com.funtl.myshop.plus.provider.domain.OutInfoCheck;

public interface OutCheckService{

    /**
     * 外访签核记录
     * @param outCheck
     * @return
     */
    Long insert(OutCheck outCheck);

    /**
     *外访签核记录数据
     * @param outBoundAuto
     * @param loginAuto
     * @return
     */
    OutInfoCheck selectOutInfoCheck(Long outBoundAuto,Long loginAuto);
}
