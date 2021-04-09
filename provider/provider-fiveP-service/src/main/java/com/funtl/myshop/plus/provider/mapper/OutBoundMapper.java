package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.ChooseCheckList;
import com.funtl.myshop.plus.provider.domain.OutBound;
import com.funtl.myshop.plus.provider.domain.OutInfo;
import com.funtl.myshop.plus.provider.domain.OutList;
import com.funtl.myshop.plus.provider.dto.OutQueryParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface OutBoundMapper extends MyMapper<OutBound> {
    /*外访客户选择签核人员*/
    List<ChooseCheckList> selectByUserAuto(@Param("userAuto") Long userAuto);

    /*判断客户是否已添加过外访报告*/
    OutBound selectTradeAuto(@Param("tradeItemAuto") Long tradeItemAuto);

    /*获取外访报告明细（签核人员与送件人员可查看）*/
    OutInfo selectOutInfo(@Param("loginAuto") Long loginAuto, @Param("tradeItemAuto") Long tradeItemAuto,@Param("outBoundAuto") Long outBoundAuto);

    /*外访新增后信息列表*/
    List<OutList> selectOutList(@Param("outQueryParam") OutQueryParam outQueryParam);
}
