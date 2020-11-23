package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.AccessaryAppService;
import com.funtl.myshop.plus.provider.api.OrderService;
import com.funtl.myshop.plus.provider.domain.CheckDetailList;
import com.funtl.myshop.plus.provider.domain.MessageList;
import com.funtl.myshop.plus.provider.domain.ZjDetail;
import com.funtl.myshop.plus.provider.dto.MessageQueryParam;
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

@Api(tags = "上牌管理模块相关操作")
@RestController
@RequestMapping(value = "request")
public class LicenseController {
    @Reference(version = "1.0.0")
    private OrderService orderService;

    @Reference(version = "1.0.0")
    private AccessaryAppService accessaryAppService;

    @ApiOperation(value = "上牌费请款：获取讯息列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型 0申购单号 1车牌号 2客户名称 6车架号 5上牌完成待请款", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "searchWord", value = "输入查询条件", required = false, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryMessages")
    public ResponseResult<List<MessageList>> queryMessages(@RequestParam(name = "type", defaultValue = "0")Integer type,
                                                              @RequestParam(name = "year", required = false)Integer year,
                                                              @RequestParam(name = "month", required = false)Integer month,
                                                              @RequestParam(name = "searchWord", required = false)String searchWord){
        MessageQueryParam messageQueryParam = new MessageQueryParam(type,year,month,searchWord);
        List<MessageList> lists = orderService.selectMessageList(messageQueryParam);
        if (lists.size() == 0){
            if (type == 5){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查询条件无未请款数据", null);
            }else {
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查询条件无数据", null);
            }
        }
        for (MessageList messageList : lists){
            if (messageList.getStatus() == 0 || messageList.getStatus() == 5){
                messageList.setCkb(1);
            }else{
                messageList.setCkb(0);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "上牌费请款：暂借明细数据且判断有没销账")
    @ApiImplicitParam(name = "orderAuto", value = "申购单号", required = true, dataType = "long", paramType = "path")
    @GetMapping(value = "queryZjDetail")
    public ResponseResult<ZjDetail> queryZjDetail(@RequestParam(name = "orderAuto") Long orderAuto){
        ZjDetail zjDetail = orderService.selectZjDetail(orderAuto);
        if (zjDetail == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查询条件无数据", null);
        }
        ZjDetail zjDetail2 = orderService.selectIsShow(orderAuto);
        zjDetail.setIsShow(zjDetail2.getIsShow());
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", zjDetail);
    }

    @ApiOperation(value = "上牌费请款：审核明细")
    @ApiImplicitParam(name = "requestAuto", value = "请款单号", required = true, dataType = "long", paramType = "path")
    @GetMapping(value = "queryCheckDetailList")
    public ResponseResult<List<CheckDetailList>> queryCheckDetailList(@RequestParam(name = "requestAuto") Long requestAuto){
        List<CheckDetailList> lists = accessaryAppService.selectCheckDetailList(requestAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }
}
