package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
import com.funtl.myshop.plus.provider.api.OrdersService;
import com.funtl.myshop.plus.provider.domain.LeasebackList;
import com.funtl.myshop.plus.provider.domain.LeasebackSelect;
import com.funtl.myshop.plus.provider.dto.LeasebackQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@Api(tags = "回租报价相关操作")
@RestController
@RequestMapping(value = "leaseback")
public class LeasebackController implements Serializable {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;

    @Reference(version = "1.0.0")
    private ItemCodeService itemCodeService;

    /**
     * 回租报价
     */

    @ApiOperation(value = "回租报价：下拉选1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemType", value = "413回租报价，326业务类别，313客户来源，135抵押地，841排档方式，231燃油种类，316付款条件中的月份", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "num", value = "对应的num", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryItemNames")
    public ResponseResult<List<LeasebackSelect>> queryItemNames(@RequestParam(name = "itemType")Integer itemType,
                                                                @RequestParam(name = "num", defaultValue = "100")Long num){
        List<LeasebackSelect> leasebackSelects = itemCodeService.selectItemName(itemType,num);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", leasebackSelects);
    }

    @ApiOperation(value = "回租报价：查询按钮")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "登录者userAuto", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "mode", value = "1报价单号 2客户名称 3业务员", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "searchWord", value = "查询条件", required = false, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "startDT", value = "开始日期", required = false, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "endDT", value = "结束日期", required = false, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryLeasebackList")
    public ResponseResult<List<LeasebackList>> queryLeasebackList(@RequestParam(name = "userAuto",required = false) Long userAuto,
                                                                  @RequestParam(name = "mode") Integer mode,
                                                                  @RequestParam(name = "searchWord",required = false) String searchWord,
                                                                  @RequestParam(name = "startDT",required = false) String startDT,
                                                                  @RequestParam(name = "endDT",required = false) String endDT){
        LeasebackQueryParam leasebackQueryParam = new LeasebackQueryParam(userAuto,mode,searchWord,startDT,endDT);
        List<LeasebackList> lists = ordersService.selectLeasebackList(leasebackQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无资料，请输入其它查询条件!", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }
}
