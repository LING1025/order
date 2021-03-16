package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.GetKeyParamDto;
import com.funtl.myshop.plus.business.dto.GiveKeyParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.CarApplicationService;
import com.funtl.myshop.plus.provider.domain.CheckList;
import com.funtl.myshop.plus.provider.domain.CheckOne;
import com.funtl.myshop.plus.provider.domain.GetKeyDto;
import com.funtl.myshop.plus.provider.domain.GiveKeyDto;
import com.funtl.myshop.plus.provider.dto.CheckQueryParam;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "车辆安排模块相关操作")
@RestController
@RequestMapping(value = "carArrange")
public class CarArrangeController {
    @Reference(version = "1.0.0")
    private CarApplicationService carApplicationService;

    @ApiOperation(value = "车辆安排：获取申请列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginAuto",value = "操作人userAuto",required = true,dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "carApplicationAuto",value = "用车申请单号",required = false,dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "username",value = "使用人",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "appUserN",value = "申请人",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "makNo",value = "车辆号码",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "planStartDT",value = "开始时间",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "planEndDT",value = "结束时间",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "statusN",value = "状态：送件中、核准",required = false,dataType = "String",paramType = "path")
    })
    @GetMapping(value = "queryCarArrange")
    public ResponseResult<List<CheckList>> queryCarArrange(@RequestParam(name = "loginAuto") Long loginAuto,
                                                           @RequestParam(name = "carApplicationAuto",required = false) Long carApplicationAuto,
                                                           @RequestParam(name = "username",required = false) String username,
                                                           @RequestParam(name = "appUserN",required = false) String appUserN,
                                                           @RequestParam(name = "planStartDT",required = false) String planStartDT,
                                                           @RequestParam(name = "planEndDT",required = false) String planEndDT,
                                                           @RequestParam(name = "makNo",required = false) String makNo,
                                                           @RequestParam(name = "statusN",required = false) String statusN){
        CheckQueryParam checkQueryParam = new CheckQueryParam(loginAuto,carApplicationAuto,username,appUserN,makNo,planStartDT,planEndDT,statusN);
        List<CheckList> lists = carApplicationService.selectCarArrange(checkQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "车辆安排：获取具体申请明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginUserID",value = "登录人userAuto",required = true,dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "carApplicationAuto",value = "用车申请单号",required = true,dataType = "long",paramType = "path")
    })
    @GetMapping(value = "queryArrangeOne")
    public ResponseResult<CheckOne> queryArrangeOne(@RequestParam(name = "loginUserID") Long loginUserID,
                                                    @RequestParam(name = "carApplicationAuto") Long carApplicationAuto){
        CheckOne checkOne = carApplicationService.selectArrangeOne(loginUserID, carApplicationAuto);
        if (checkOne == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",checkOne);
    }

    @ApiOperation(value = "车辆安排：发放钥匙(此接口如要测试请联系后端)")
    @PutMapping(value = "giveKeyUpdate")
    public ResponseResult<String> GiveKeyUpdate(@ApiParam(value = "车辆安排：发放钥匙数据")@Valid @RequestBody GiveKeyParamDto giveKeyParamDto){
        GiveKeyDto giveKeyDto = new GiveKeyDto();
        BeanUtils.copyProperties(giveKeyParamDto,giveKeyDto);
        Integer i = carApplicationService.giveKeyUpdate(giveKeyDto);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"发放失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"发放成功",null);
    }

    @ApiOperation(value = "车辆领取：领取钥匙(此接口如要测试请联系后端)")
    @PutMapping(value = "getKeyUpdate")
    public ResponseResult<String> GetKeyUpdate(@ApiParam(value = "车辆领取：领取钥匙数据")@Valid @RequestBody GetKeyParamDto getKeyParamDto){
        GetKeyDto getKeyDto = new GetKeyDto();
        BeanUtils.copyProperties(getKeyParamDto,getKeyDto);
        Integer i = carApplicationService.getKeyUpdate(getKeyDto);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"领取失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"领取成功",null);
    }
}
