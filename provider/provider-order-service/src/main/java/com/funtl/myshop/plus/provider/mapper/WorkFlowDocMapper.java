package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.SignOffList;
import com.funtl.myshop.plus.provider.domain.WorkFlowDoc;
import com.funtl.myshop.plus.provider.dto.FlowAuditDto;
import com.funtl.myshop.plus.provider.dto.FlowCURDto;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface WorkFlowDocMapper extends MyMapper<WorkFlowDoc> {

    List<WorkFlowDoc> selectWorkFlowDoc(@Param("docPostID") Long docPostID, @Param("roleId") Integer roleId, @Param("type") Integer type);

    Integer insertFlowAudit(@Param("flowAuditDto") FlowAuditDto flowAuditDto);

    Integer insertFlowCUR(@Param("flowCURDto") FlowCURDto flowCURDto);
}
