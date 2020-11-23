package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.AccessaryApp;
import com.funtl.myshop.plus.provider.domain.CheckDetailList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface AccessaryAppMapper extends MyMapper<AccessaryApp> {
    List<CheckDetailList> selectCheckDetailList(@Param("requestAuto") Long requestAuto);
}
