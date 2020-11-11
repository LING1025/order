package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.ClientCheckParamDto;
import com.funtl.myshop.plus.business.dto.CrmDetailParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.RptVstFlowService;
import com.funtl.myshop.plus.provider.api.RptVstService;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.ClientCheckDto;
import com.funtl.myshop.plus.provider.dto.TripQueryParam;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @ApiOperation(value = "行程报告审核(此接口如要测试请联系后端)")
    @PutMapping(value = "update")
    public ResponseResult<String> update(@ApiParam(value = "行程报告审核数据") @Valid @RequestBody ClientCheckParamDto clientCheckParamDto){
        if (clientCheckParamDto.getMemo() == null || clientCheckParamDto.getMemo().isEmpty()){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "请输入审核意见！", null);
        }
        ClientCheckDto clientCheckDto = new ClientCheckDto();
        BeanUtils.copyProperties(clientCheckParamDto,clientCheckDto);
        Integer i = rptVstFlowService.update(clientCheckDto);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "审核失败", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "审核完成", null);
    }

    @ApiOperation(value = "获取CRM行程报告列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "用户序号", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "customerName", value = "客户名称", required = false, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryCrmTripList")
    public ResponseResult<List<CrmTripList>> queryCrmTripList(@RequestParam(name = "userAuto")Integer userAuto,
                                                              @RequestParam(name = "customerName", required = false)String customerName){
        List<CrmTripList> lists = rptVstService.selectCrmTripList(userAuto,customerName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "获取CRM行程报告具体数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rptVstAuto", value = "报告序号", required = true, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryCrmDetail")
    public ResponseResult<CrmDetail> queryCrmDetail(@RequestParam(name = "rptVstAuto")Long rptVstAuto){
        CrmDetail crmDetail = rptVstService.selectByRptVstAuto(rptVstAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", crmDetail);
    }

    @ApiOperation(value = "编辑CRM行程报告数据(此接口如要测试请联系后端)")
    @PutMapping(value = "updateByRptVstAuto")
    public ResponseResult<String> updateByRptVstAuto(@ApiParam(value = "CRM行程报告数据") @Valid @RequestBody CrmDetailParamDto crmDetailParamDto){
        if (crmDetailParamDto.getRptVstAuto() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        RptVst rptVst = new RptVst();
        BeanUtils.copyProperties(crmDetailParamDto,rptVst);
        Integer i = rptVstService.update(rptVst);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "修改失败", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "修改成功", null);
    }

    @ApiOperation(value = "获取客户名称、联系人下拉选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型 1客户名称 2联系人 3全部客户名称", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "tradeItemAuto", value = "报告序号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryFNameAndName")
    public ResponseResult<List<CrmSelect>> queryFNameAndName(@RequestParam(name = "type")Integer type,
                                                    @RequestParam(name = "tradeItemAuto", required = false)Long tradeItemAuto){
        List<CrmSelect> crmSelects = rptVstService.selectByTradeItemAuto(tradeItemAuto,type);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", crmSelects);
    }

}
