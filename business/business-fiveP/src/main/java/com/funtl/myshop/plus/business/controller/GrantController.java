package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
import com.funtl.myshop.plus.provider.api.OrdersService;
import com.funtl.myshop.plus.provider.domain.GrantList;
import com.funtl.myshop.plus.provider.domain.LicensePlateList;
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

@Api(tags = "拨款申请作业相关操作")
@RestController
@RequestMapping(value = "grant")
public class GrantController {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;

    @Reference(version = "1.0.0")
    private ItemCodeService itemCodeService;

    @ApiOperation(value = "拨款申请作业：查询按钮、列印订车单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "查询类别：1授信单号 2客户名称 4请购单号",required = true,dataType = "int",paramType = "path"),
            @ApiImplicitParam(name = "searchWord",value = "输入查询条件",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "userAuto",value = "登录人userAuto",required = true,dataType = "long",paramType = "path")
    })
    @GetMapping(value = "queryGrantList")
    public ResponseResult<List<GrantList>> queryGrantList(@RequestParam(name = "type",defaultValue = "1") Integer type,
                                                            @RequestParam(name = "searchWord") String searchWord,
                                                            @RequestParam(name = "userAuto") Long userAuto){
        PaymentQueryParam paymentQueryParam = new PaymentQueryParam(3,type,searchWord,userAuto,"",0L);
        List<GrantList> lists = ordersService.selectGrantList(paymentQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"无相关数据",null);
        }
        for (GrantList grantList : lists){
            List<LicensePlateList> licensePlateLists = itemCodeService.selectLicense(grantList.getInsureAddr(),1);
            for (LicensePlateList licensePlateList : licensePlateLists){
                grantList.setInsureAddrN(licensePlateList.getInsureAddrN());
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "拨款申请作业：出保单地下拉选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "1根据序号(查询按钮会返回insureAddr)获取出保单地 2出保单地下拉选所有数据",required = true,dataType = "int",paramType = "path"),
            @ApiImplicitParam(name = "insureAddr",value = "出保单地序号",required = true,dataType = "int",paramType = "path")
    })
    @GetMapping(value = "queryLicense")
    public ResponseResult<List<LicensePlateList>> queryLicense(@RequestParam(name = "type",defaultValue = "2") Integer type,
                                                               @RequestParam(name = "insureAddr",defaultValue = "0") Integer insureAddr){
        List<LicensePlateList> lists = itemCodeService.selectLicense(insureAddr,type);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }
}
