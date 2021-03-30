package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.ChooseCheckList;
import com.funtl.myshop.plus.provider.domain.OutBound;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OutBoundMapper extends MyMapper<OutBound> {
    /*外访客户选择签核人员*/
    List<ChooseCheckList> selectByUserAuto(@Param("userAuto") Long userAuto);
}
