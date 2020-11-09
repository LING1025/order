package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.RptVstFlowService;
import com.funtl.myshop.plus.provider.domain.RptVstFlow;
import com.funtl.myshop.plus.provider.domain.TripDetailList;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "客户模块相关操作")
@RestController
@RequestMapping(value = "client")
public class ClientController {
    @Reference(version = "1.0.0")
    private RptVstFlowService rptVstFlowService;

    @ApiOperation(value = "根据行程单号获取审核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rptVstAuto", value = "行程单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryTripDetailList")
    public ResponseResult<List<TripDetailList>> queryTripDetailList(@RequestParam(name = "rptVstAuto", required = false)Long rptVstAuto ){
        List<TripDetailList> lists = rptVstFlowService.selectByRptVstAuto(rptVstAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }
}
