package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
import com.funtl.myshop.plus.provider.api.TradeItemService;
import com.funtl.myshop.plus.provider.domain.CusBackground;
import com.funtl.myshop.plus.provider.domain.TypeNameList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "外访报告模块相关操作")
@RestController
@RequestMapping(value = "outBound")
public class FivePController {
    @Reference(version = "1.0.0")
    private ItemCodeService itemCodeService;

    @Reference(version = "1.0.0")
    private TradeItemService tradeItemService;

    @ApiOperation(value = "获取客户性质、产业类别、租车目的、担保条件")
    @ApiImplicitParam(name = "itemType", value = "客户性质：111,产业类别：140,租车目的：12223,担保条件：12224",required = true,dataType ="int",paramType = "path")
    @GetMapping(value = "queryItemType")
    public ResponseResult<List<TypeNameList>> queryItemType(@RequestParam(name = "itemType") Integer itemType){
        List<TypeNameList> lists = itemCodeService.selectByItemType(itemType);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "获取客户背景数据")
    @ApiImplicitParam(name = "tradeItemAuto", value = "客户序号",required = true,dataType ="int",paramType = "path")
    @GetMapping(value = "queryByTradeItemAuto")
    public ResponseResult<CusBackground> queryByTradeItemAuto(@RequestParam(name = "tradeItemAuto") Long tradeItemAuto){
        CusBackground cusBackground = tradeItemService.selectByTradeItemAuto(tradeItemAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",cusBackground);
    }
}
