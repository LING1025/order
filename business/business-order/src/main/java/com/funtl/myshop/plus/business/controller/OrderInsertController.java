package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.FlowAuditParamDto;
import com.funtl.myshop.plus.business.dto.FlowCURParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.OrdersFDetailService;
import com.funtl.myshop.plus.provider.api.WorkFlowDocService;
import com.funtl.myshop.plus.provider.dto.FlowAuditDto;
import com.funtl.myshop.plus.provider.dto.FlowCURDto;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "直租、回租试算签核相关新增操作")
@RestController
@RequestMapping(value = "orderInsert")
public class OrderInsertController {
    @Reference(version = "1.0.0")
    private WorkFlowDocService workFlowDocService;

    @Reference(version = "1.0.0")
    private OrdersFDetailService ordersFDetailService;

    @ApiOperation(value = "签核、核准(此接口如要测试请联系后端)")
    @PostMapping(value = "flowAudit")
    public ResponseResult<String> FlowAuditInsert(@ApiParam(value = "签核、核准数据") @Valid @RequestBody FlowAuditParamDto flowAuditParamDto){
        FlowAuditDto flowAuditDto = new FlowAuditDto();
        BeanUtils.copyProperties(flowAuditParamDto,flowAuditDto);
        Integer i = workFlowDocService.insert(flowAuditDto);
        if (i == 0){
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "保存成功", null);
    }

    @ApiOperation(value = "驳回、作废(此接口如要测试请联系后端)")
    @PostMapping(value = "flowCUR")
    public ResponseResult<String> FlowCURInsert(@ApiParam(value = "驳回、作废数据") @Valid @RequestBody FlowCURParamDto flowCURParamDto){
        FlowCURDto flowCURDto = new FlowCURDto();
        BeanUtils.copyProperties(flowCURParamDto,flowCURDto);
        Integer i = workFlowDocService.insertFlowCUR(flowCURDto);
        if (i == 0){
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "保存成功", null);
    }

}
