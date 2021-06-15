package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.OrdersService;
import com.funtl.myshop.plus.provider.domain.PaymentList;
import com.funtl.myshop.plus.provider.dto.PaymentQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "客户汇款输入相关操作")
@RestController
@RequestMapping(value = "payment")
public class PaymentController {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;

    @ApiOperation(value = "客户汇款输入：查询按钮")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Type",value = "查询类别：1授信单号 2客户名称",required = true,dataType = "int",paramType = "path"),
            @ApiImplicitParam(name = "SearchWord",value = "输入要查询的内容",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "UserAuto",value = "登录人userAuto",required = true,dataType = "long",paramType = "path")
    })
    @GetMapping(value = "queryPaymentList")
    public ResponseResult<List<PaymentList>> queryPaymentList(@RequestParam(name = "Type",defaultValue = "2") Integer Type,
                                                              @RequestParam(name = "SearchWord") String SearchWord,
                                                              @RequestParam(name = "UserAuto") Long UserAuto){
        PaymentQueryParam paymentQueryParam = new PaymentQueryParam(2,Type,SearchWord,UserAuto,"",0L);
        List<PaymentList> lists = ordersService.selectPaymentList(paymentQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"无相关数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }
}
