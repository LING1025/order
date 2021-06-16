package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.OrdersService;
import com.funtl.myshop.plus.provider.domain.IncomeList;
import com.funtl.myshop.plus.provider.domain.PaymentFileList;
import com.funtl.myshop.plus.provider.domain.PaymentList;
import com.funtl.myshop.plus.provider.dto.IncomeDto;
import com.funtl.myshop.plus.provider.dto.PaymentQueryParam;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@Api(value = "客户汇款输入相关操作")
@RestController
@RequestMapping(value = "payment")
public class PaymentController {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;

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
}
