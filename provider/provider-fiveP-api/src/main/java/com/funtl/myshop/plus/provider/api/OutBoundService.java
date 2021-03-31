package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ChooseCheckList;
import com.funtl.myshop.plus.provider.domain.OutBound;
import com.funtl.myshop.plus.provider.domain.OutInfo;

import java.util.List;

public interface OutBoundService{

    /**
     * 外访客户新增数据
     * @param outBound
     * @return
     */
    Long insert(OutBound outBound);

    /**
     * 外访客户选择签核人员
     * @param userAuto
     * @return
     */
    List<ChooseCheckList> selectByUserAuto(Long userAuto);

    /**
     * 根据主键删除
     * @param outBoundAuto
     * @return
     */
    Integer deleteByAuto(Long outBoundAuto);

    /**
     * 判断客户是否已添加过外访报告
     * @param tradeItemAuto
     * @return
     */
    OutBound selectTradeAuto(Long tradeItemAuto);

    /**
     * 获取外访报告明细（签核人员与送件人员可查看）
     * @param loginAuto
     * @param tradeItemAuto
     * @return
     */
    OutInfo selectOutInfo(Long loginAuto,Long tradeItemAuto)
}
