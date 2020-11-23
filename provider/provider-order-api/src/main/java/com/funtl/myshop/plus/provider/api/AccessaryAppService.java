package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AccessaryApp;
import com.funtl.myshop.plus.provider.domain.CheckDetailList;

public interface AccessaryAppService{

    /**
     * 上牌费请款：审核明细
     * @param requestAuto
     * @return
     */
    CheckDetailList selectCheckDetailList(Long requestAuto);

}
