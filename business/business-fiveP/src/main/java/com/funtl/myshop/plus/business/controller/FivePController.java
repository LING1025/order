package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.OutCheckParamDto;
import com.funtl.myshop.plus.business.dto.OutParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
import com.funtl.myshop.plus.provider.api.OutBoundService;
import com.funtl.myshop.plus.provider.api.OutCheckService;
import com.funtl.myshop.plus.provider.api.TradeItemService;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.OutQueryParam;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Api(tags = "外访报告模块相关操作")
@RestController
@RequestMapping(value = "outBound")
public class FivePController {
    @Reference(version = "1.0.0")
    private ItemCodeService itemCodeService;

    @Reference(version = "1.0.0")
    private TradeItemService tradeItemService;

    @Reference(version = "1.0.0")
    private OutBoundService outBoundService;

    @Reference(version = "1.0.0")
    private OutCheckService outCheckService;

    @ApiOperation(value = "获取客户性质、产业类别、租车目的、担保条件")
    @ApiImplicitParam(name = "itemType", value = "客户性质：111,产业类别：140,租车目的：12223,担保条件：12224",required = true,dataType ="int",paramType = "path")
    @GetMapping(value = "queryItemType")
    public ResponseResult<List<TypeNameList>> queryItemType(@RequestParam(name = "itemType") Integer itemType){
        List<TypeNameList> lists = itemCodeService.selectByItemType(itemType);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "获取客户背景数据")
    @ApiImplicitParam(name = "tradeItemAuto", value = "客户序号",required = true,dataType ="long",paramType = "path")
    @GetMapping(value = "queryByTradeItemAuto")
    public ResponseResult<CusBackground> queryByTradeItemAuto(@RequestParam(name = "tradeItemAuto") Long tradeItemAuto){
        CusBackground cusBackground = tradeItemService.selectByTradeItemAuto(tradeItemAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",cusBackground);
    }

    @ApiOperation(value = "获取可签核人员信息")
    @ApiImplicitParam(name = "userAuto", value = "登录人userAuto",required = true,dataType ="long",paramType = "path")
    @GetMapping(value = "queryChooseList")
    public ResponseResult<List<ChooseCheckList>> queryChooseList(@RequestParam(name = "userAuto") Long userAuto){
        List<ChooseCheckList> lists = outBoundService.selectByUserAuto(userAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"查询成功",lists);
    }

    @ApiOperation(value = "外访客户新增数据")
    @PostMapping(value = "insert")
    public ResponseResult<String> insert(@ApiParam(value = "外访客户新增数据") @Valid @RequestBody OutParamDto outParamDto){
        if (outParamDto.getTradeItemAuto()==0L){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"客户序号未填",null);
        }
        OutBound outBound2 = outBoundService.selectTradeAuto(outParamDto.getTradeItemAuto());
        if (outBound2 != null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"此客户已添加过外访报告信息",null);
        }
        outParamDto.setCdt(new Date());
        OutBound outBound = new OutBound();
        BeanUtils.copyProperties(outParamDto,outBound);
        if(outParamDto.getCheckAuto() == 0L){
            outBound.setStatus(2);
        }else{
            outBound.setStatus(1);
        }
        Long i = outBoundService.insert(outBound);
        if(i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"保存失败",null);
        }
        OutCheck outCheck = new OutCheck();
        BeanUtils.copyProperties(outParamDto,outCheck);
        outCheck.setOutBoundAuto(i);
        if(outParamDto.getCheckAuto() == 0L){
            outCheck.setCheckStatus(2);
            outCheck.setCheckDT(new Date());
            outCheck.setMemo("OK");
        }else{
            outCheck.setCheckStatus(1);
        }
        Long i2 = outCheckService.insert(outCheck);
        if(i2 == 0){
            outBoundService.deleteByAuto(i);
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"保存失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"保存成功","新增数据的outBoundAuto："+i);
    }

    @ApiOperation(value = "获取外访报告新增后信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginAuto", value = "登录人userAuto",required = true,dataType ="long",paramType = "path"),
            @ApiImplicitParam(name = "tradeItemAuto", value = "客户序号",required = true,dataType ="long",paramType = "path"),
            @ApiImplicitParam(name = "type", value = "查询类别：1送件人员查看,2签核人员查看",required = true,dataType ="int",paramType = "path")
    })
    @GetMapping(value = "queryOutList")
    public ResponseResult<List<OutList>> queryOutList(@RequestParam(name = "loginAuto") Long loginAuto,
                                                @RequestParam(name = "tradeItemAuto") Long tradeItemAuto,
                                                @RequestParam(name = "type") Integer type){
        OutQueryParam outQueryParam = new OutQueryParam(loginAuto,tradeItemAuto,type);
        List<OutList> list = outBoundService.selectOutList(outQueryParam);
        if (list.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无资料",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }

    @ApiOperation(value = "获取外访报告明细")
    @ApiImplicitParam(name = "outBoundAuto", value = "外访客户表序号",required = true,dataType ="long",paramType = "path")
    @GetMapping(value = "queryOutInfo")
    public ResponseResult<OutInfo> queryOutInfo(@RequestParam(name = "outBoundAuto") Long outBoundAuto){
        OutInfo outInfo = outBoundService.selectOutInfo(outBoundAuto);
        if (outInfo == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无资料",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",outInfo);
    }

    @ApiOperation(value = "获取外访签核记录数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginAuto", value = "登录人userAuto",required = true,dataType ="long",paramType = "path"),
            @ApiImplicitParam(name = "outBoundAuto", value = "外访客户表序号",required = true,dataType ="long",paramType = "path")
    })
    @GetMapping(value = "queryOutInfoCheck")
    public ResponseResult<OutInfoCheck> queryOutInfoCheck(@RequestParam(name = "outBoundAuto") Long outBoundAuto,
                                                          @RequestParam(name = "loginAuto") Long loginAuto){
        OutInfoCheck outInfoCheck = outCheckService.selectOutInfoCheck(outBoundAuto,loginAuto);
        if (outInfoCheck == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无签核记录",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",outInfoCheck);
    }

    @ApiOperation(value = "对外访客户明细核准或驳回")
    @PutMapping(value = "update")
    public ResponseResult<String> update(@ApiParam(value = "对外访客户明细核准或驳回") @Valid @RequestBody OutCheckParamDto outCheckParamDto){
        if (outCheckParamDto.getOutBoundAuto() == 0L || outCheckParamDto.getOutCheckAuto() == 0L || outCheckParamDto.getLoginAuto() == 0L){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"参数异常",null);
        }
        outCheckParamDto.setMuser(outCheckParamDto.getLoginAuto());
        outCheckParamDto.setMdt(new Date());
        OutBound outBound = new OutBound();
        BeanUtils.copyProperties(outCheckParamDto,outBound);
        outBound.setStatus(outCheckParamDto.getCheckStatus());
        Integer i = outBoundService.update(outBound);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"审核失败",null);
        }

        OutCheck outCheck = new OutCheck();
        BeanUtils.copyProperties(outCheckParamDto,outCheck);
        outCheck.setCheckDT(new Date());
        Integer i2 = outCheckService.update(outCheck);
        if (i2 == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"审核失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"审核成功",null);
    }
}
