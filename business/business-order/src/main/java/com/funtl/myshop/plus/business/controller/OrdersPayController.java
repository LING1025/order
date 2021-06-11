package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.OrdersPayParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.OrdersService;
import com.funtl.myshop.plus.provider.domain.OrdersPayList;
import com.funtl.myshop.plus.provider.dto.OrdersPayDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @ApiOperation(value = "付款日修改审核：核准、驳回")
    @PostMapping(value = "insert")
    public ResponseResult<String> insert(@ApiParam(value = "付款日修改审核：核准、驳回") @Valid @RequestBody OrdersPayParamDto ordersPayParamDto){
        OrdersPayDto ordersPayDto = new OrdersPayDto();
        if (ordersPayParamDto.getUserAuto() != ordersPayParamDto.getLoginUserAuto()){
            ordersPayParamDto.setType(1);
        }else{
            ordersPayParamDto.setType(0);
        }
        BeanUtils.copyProperties(ordersPayParamDto,ordersPayDto);
        Integer i = ordersService.insert(ordersPayDto);
        if (i == 0){
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "保存成功", null);
    }
}
