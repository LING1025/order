package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.SignOffList;
import com.funtl.myshop.plus.provider.domain.WorkFlowDoc;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

public interface WorkFlowDocMapper extends MyMapper<WorkFlowDoc> {
    SignOffList selectSignOffList(@Param("docPostID") Integer docPostID, @Param("roleId") Integer roleId);
}
