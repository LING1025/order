package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.OutCheck;
import com.funtl.myshop.plus.provider.domain.OutInfoCheck;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

public interface OutCheckMapper extends MyMapper<OutCheck> {

    /*外访签核记录数据*/
    OutInfoCheck selectOutInfoCheck(@Param("outBoundAuto") Long outBoundAuto, @Param("loginAuto") Long loginAuto);
}
