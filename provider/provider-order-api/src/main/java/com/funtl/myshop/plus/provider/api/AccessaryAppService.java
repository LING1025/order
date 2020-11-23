package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.AccessaryApp;
import com.funtl.myshop.plus.provider.domain.CheckDetailList;

import java.util.List;

public interface AccessaryAppService{

    /**
     * 上牌费请款：审核明细
     * @param requestAuto
     * @return
     */
    List<CheckDetailList> selectCheckDetailList(Long requestAuto);

}
