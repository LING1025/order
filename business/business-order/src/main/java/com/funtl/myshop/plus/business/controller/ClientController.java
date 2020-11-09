package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.RptVstFlowService;
import com.funtl.myshop.plus.provider.api.RptVstService;
import com.funtl.myshop.plus.provider.domain.RptVst;
import com.funtl.myshop.plus.provider.domain.RptVstFlow;
import com.funtl.myshop.plus.provider.domain.TripDetailList;
import com.funtl.myshop.plus.provider.domain.TripRecorderList;
import com.funtl.myshop.plus.provider.dto.TripQueryParam;
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

    @Reference(version = "1.0.0")
    private RptVstService rptVstService;

    @ApiOperation(value = "根据行程单号获取审核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rptVstAuto", value = "行程单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryTripDetailList")
    public ResponseResult<List<TripDetailList>> queryTripDetailList(@RequestParam(name = "rptVstAuto", required = false)Long rptVstAuto ){
        List<TripDetailList> lists = rptVstFlowService.selectByRptVstAuto(rptVstAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "获取行程报告记录-主档信息待签核")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "status", value = "状态 0 未审核 1 已审核", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "userAuto", value = "操作人序号", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "roleAuto", value = "权限序号", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "orgAuto", value = "部门序号", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryTripRecorderOne")
    public ResponseResult<List<TripRecorderList>> queryTripRecorderOne(@RequestParam(name = "year", required = false)Integer year,
                                                                        @RequestParam(name = "month", required = false)Integer month,
                                                                        @RequestParam(name = "status", required = false)Integer status,
                                                                        @RequestParam(name = "userAuto", required = false)Integer userAuto,
                                                                        @RequestParam(name = "roleAuto", required = false)Integer roleAuto,
                                                                        @RequestParam(name = "orgAuto", required = false)Integer orgAuto){
        TripQueryParam tripQueryParam = new TripQueryParam(year,month,status,userAuto,roleAuto,orgAuto);
        List<TripRecorderList> lists = rptVstService.selectByTrip(tripQueryParam);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "获取行程报告记录-可跨签信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "status", value = "状态 0 未审核 1 已审核", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "userAuto", value = "操作人序号", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "roleAuto", value = "权限序号", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "orgAuto", value = "部门序号", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryTripRecorderTwo")
    public ResponseResult<List<TripRecorderList>> queryTripRecorderTwo(@RequestParam(name = "year", required = false)Integer year,
                                                                        @RequestParam(name = "month", required = false)Integer month,
                                                                        @RequestParam(name = "status", required = false)Integer status,
                                                                        @RequestParam(name = "userAuto", required = false)Integer userAuto,
                                                                        @RequestParam(name = "roleAuto", required = false)Integer roleAuto,
                                                                        @RequestParam(name = "orgAuto", required = false)Integer orgAuto){
        TripQueryParam tripQueryParam = new TripQueryParam(year,month,status,userAuto,roleAuto,orgAuto);
        List<TripRecorderList> lists = rptVstService.selectByTripTwo(tripQueryParam);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }
}
