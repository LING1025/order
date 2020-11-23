package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.ClasenList;
import com.funtl.myshop.plus.provider.domain.MessageList;
import com.funtl.myshop.plus.provider.domain.Order;
import com.funtl.myshop.plus.provider.domain.ZjDetail;
import com.funtl.myshop.plus.provider.dto.MessageQueryParam;

import java.util.List;

public interface OrderService{

    /**
     * 根据试算单号获取报价车型历史成交记录
     * @param ordersAuto
     * @return
     */
    List<ClasenList> selectClasenList(Long ordersAuto);

    /**
     * 上牌费请款：获取讯息列表信息
     * @param messageQueryParam
     * @return
     */
    List<MessageList> selectMessageList(MessageQueryParam messageQueryParam);

    /**
     * 上牌费请款：暂借明细数据
     * @param orderAuto
     * @return
     */
    ZjDetail selectZjDetail(Long orderAuto);

    /**
     * 上牌费请款：暂借明细判断有没销账
     * @param orderAuto
     * @return
     */
    ZjDetail selectIsShow(Long orderAuto);
}
