package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.IncomeInsertParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
import com.funtl.myshop.plus.provider.api.OrdersService;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.IncomeDto;
import com.funtl.myshop.plus.provider.dto.IncomeInsertDto;
import com.funtl.myshop.plus.provider.dto.PaymentQueryParam;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Api(tags = "客户汇款输入相关操作")
@RestController
@RequestMapping(value = "payment")
public class PaymentController {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;

    @Reference(version = "1.0.0")
    private ItemCodeService itemCodeService;

    @ApiOperation(value = "客户汇款输入：查询按钮")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "查询类别：1授信单号 2客户名称",required = true,dataType = "int",paramType = "path"),
            @ApiImplicitParam(name = "searchWord",value = "输入查询条件",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "userAuto",value = "登录人userAuto",required = true,dataType = "long",paramType = "path")
    })
    @GetMapping(value = "queryPaymentList")
    public ResponseResult<List<PaymentList>> queryPaymentList(@RequestParam(name = "type",defaultValue = "2") Integer type,
                                                              @RequestParam(name = "searchWord") String searchWord,
                                                              @RequestParam(name = "userAuto") Long userAuto){
        PaymentQueryParam paymentQueryParam = new PaymentQueryParam(2,type,searchWord,userAuto,"",0L);
        List<PaymentList> lists = ordersService.selectPaymentList(paymentQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"无相关数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "客户汇款输入：客户汇款记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "查询类别：1依授信单号 2依汇款序号",required = true,paramType = "int",dataType = "path"),
            @ApiImplicitParam(name = "searchWord",value = "输入查询条件",required = true,paramType = "String",dataType = "path")
    })
    @GetMapping(value = "queryIncomeList")
    public ResponseResult<IncomeDto> queryIncomeList(@RequestParam(name = "type") Integer type,
                                                           @RequestParam(name = "searchWord") String searchWord){
        List<IncomeList> lists = ordersService.selectIncomeList(type, searchWord);
        IncomeDto incomeDto = new IncomeDto();
        incomeDto.setRows(lists.size());
        incomeDto.setIncomeListList(lists);
        double sum = 0;
        for (IncomeList incomeList : lists
             ) {
            sum += incomeList.getAmt().doubleValue();
        }
        incomeDto.setTotalAmt(BigDecimal.valueOf(sum));
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",incomeDto);
    }

    @ApiOperation(value = "客户汇款输入：附件列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "1获取附件信息",required = true,dataType = "int",paramType = "path"),
            @ApiImplicitParam(name = "docPostId",value = "授信单号",required = true,dataType = "long",paramType = "path")
    })
    @GetMapping(value = "queryPaymentFileList")
    public ResponseResult<List<PaymentFileList>> queryPaymentFileList(@RequestParam(name = "type") Integer type,
                                                                      @RequestParam(name = "docPostId") Long docPostId){
        List<PaymentFileList> lists = ordersService.selectPaymentFileList(type,docPostId);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"无相关数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "汇款类别下拉选")
    @ApiImplicitParam(name = "itemType", value = "获取汇款类别:2030",required = true,dataType ="int",paramType = "path")
    @GetMapping(value = "queryItemType")
    public ResponseResult<List<TypeNameList>> queryItemType(@RequestParam(name = "itemType") Integer itemType){
        List<TypeNameList> lists = itemCodeService.selectByItemType(itemType);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "进款公司别下拉选")
    @ApiImplicitParam(name = "incName", value = "公司别",required = true,dataType ="String",paramType = "path")
    @GetMapping(value = "queryIncNameList")
    public ResponseResult<List<IncNameList>> queryIncNameList(@RequestParam(name = "incName") String incName){
        List<IncNameList> lists = itemCodeService.selectIncNameList(incName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "根据进款公司别序号获取进款账号")
    @ApiImplicitParam(name = "incAuto", value = "公司别序号",required = true,dataType ="long",paramType = "path")
    @GetMapping(value = "queryAccountNameList")
    public ResponseResult<List<AccountNameList>> queryAccountNameList(@RequestParam(name = "incAuto",defaultValue = "0")Long incAuto){
        List<AccountNameList> lists = itemCodeService.selectAccountNameList(incAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation("客户汇款输入：新增汇款")
    @PostMapping(value = "create")
    public ResponseResult<String> create(@ApiParam(value = "新增汇款") @Valid @RequestBody IncomeInsertParamDto incomeInsertParamDto){
        if (incomeInsertParamDto.getCreditMainAuto() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"授信单号不能为空",null);
        }
        //捕获空指针异常
        try{
            //判断汇款类别是否重复
            Integer type = ordersService.selectType(incomeInsertParamDto.getType(),incomeInsertParamDto.getCreditMainAuto());
            System.out.println("判断汇款类别是否重复:type="+type);
            if (type > 0){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"汇款类别不能重复",null);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        IncomeInsertDto incomeInsertDto = new IncomeInsertDto();
        BeanUtils.copyProperties(incomeInsertParamDto,incomeInsertDto);
        Integer i = ordersService.createIncome(incomeInsertDto);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"新增失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"新增成功",null);
    }
}
