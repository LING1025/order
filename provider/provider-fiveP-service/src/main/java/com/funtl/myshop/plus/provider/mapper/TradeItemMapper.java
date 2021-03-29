package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.CusBackground;
import com.funtl.myshop.plus.provider.domain.TradeItem;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

public interface TradeItemMapper extends MyMapper<TradeItem> {
    CusBackground selectByTradeItemAuto(@Param("tradeItemAuto") Long tradeItemAuto);
}
