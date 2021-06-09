package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.OrdersService;
import com.funtl.myshop.plus.provider.domain.OrdersPayList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "付款日修改审核相关操作")
@RestController
@RequestMapping(value = "ordersPay")
public class OrdersPayController {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;

    @ApiOperation(value = "获取需审核列表数据")
    @ApiImplicitParam(name = "userAuto",value = "操作人userAuto",required = true,dataType = "long",paramType = "path")
    @GetMapping(value = "queryOrdersPayList")
    public ResponseResult<List<OrdersPayList>> queryOrdersPayList(@RequestParam(name = "userAuto") Long userAuto){
        if (userAuto == 0L){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请选择操作人",null);
        }
        List<OrdersPayList> lists = ordersService.selectOrdersPayList(userAuto);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"待签核数：0",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }
}
