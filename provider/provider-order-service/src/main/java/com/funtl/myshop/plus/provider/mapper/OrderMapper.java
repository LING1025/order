package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.ClasenList;
import com.funtl.myshop.plus.provider.domain.MessageList;
import com.funtl.myshop.plus.provider.domain.Order;
import com.funtl.myshop.plus.provider.domain.ZjDetail;
import com.funtl.myshop.plus.provider.dto.MessageQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OrderMapper extends MyMapper<Order> {
    List<ClasenList> selectClasenList(@Param("param") Long ordersAuto);

    List<MessageList> selectMessageList(@Param("param") MessageQueryParam messageQueryParam);

    ZjDetail selectZjDetail(@Param("orderAuto")Long orderAuto);

    ZjDetail selectIsShow(@Param("orderAuto")Long orderAuto);
}
