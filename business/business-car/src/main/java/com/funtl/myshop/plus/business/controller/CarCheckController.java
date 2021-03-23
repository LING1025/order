package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.CarChangeParamDto;
import com.funtl.myshop.plus.business.dto.UseCarCheckParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.AspnetUsersService;
import com.funtl.myshop.plus.provider.api.CarApplicationService;
import com.funtl.myshop.plus.provider.api.VEmpService;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.CarChangeDto;
import com.funtl.myshop.plus.provider.dto.CheckQueryParam;
import com.funtl.myshop.plus.provider.dto.UseCarCheckDto;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "用车审核模块相关操作")
@RestController
@RequestMapping(value = "carCheck")
public class CarCheckController {
    @Reference(version = "1.0.0")
    private VEmpService vEmpService;

    @Reference(version = "1.0.0")
    private CarApplicationService carApplicationService;

    @Reference(version = "1.0.0")
    private AspnetUsersService aspnetUsersService;

    @ApiOperation(value = "用车审核：选择代理人")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "代理人id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryAgentList")
    public ResponseResult<List<AgentList>> queryAgentList(@RequestParam(name = "userAuto",required = false) Long userAuto){
        //代理人id查询
        List<AgentList> lists = vEmpService.selectAgentList(userAuto);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"查无资料，请输入其它查询条件!",null);
        }
        List<AgentList> agentLists = Lists.newArrayList();
        for(AgentList agentList : lists){
            VEmp vEmp = vEmpService.selectByUserAuto(agentList.getSelfUser());
            if(vEmp != null){
                AspnetUsers aspnetUsers = aspnetUsersService.selectByAppId("73663109-dda2-4c2d-8311-337946b5c373",vEmp.getUserId());
                if(aspnetUsers != null) {
                    AgentList agentList1 = new AgentList();
                    agentList1.setSelfUser(agentList.getSelfUser());
                    agentList1.setSelfName(vEmp.getFName() + "_" + vEmp.getDepName());
                    agentLists.add(agentList1);
                }
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", agentLists);
    }

    @ApiOperation(value = "用车审核：获取审核列表")
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
    @GetMapping(value = "queryCheckList")
    public ResponseResult<List<CheckList>> queryCheckList(@RequestParam(name = "loginAuto") Long loginAuto,
                                                          @RequestParam(name = "carApplicationAuto",required = false) Long carApplicationAuto,
                                                          @RequestParam(name = "username",required = false) String username,
                                                          @RequestParam(name = "appUserN",required = false) String appUserN,
                                                          @RequestParam(name = "planStartDT",required = false) String planStartDT,
                                                          @RequestParam(name = "planEndDT",required = false) String planEndDT,
                                                          @RequestParam(name = "makNo",required = false) String makNo,
                                                          @RequestParam(name = "statusN",required = false) String statusN){
        CheckQueryParam checkQueryParam = new CheckQueryParam(loginAuto,carApplicationAuto,username,appUserN,makNo,planStartDT,planEndDT,statusN);
        List<CheckList> lists = carApplicationService.selectCheckList(checkQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "用车审核：选取审核明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginUserID",value = "登录人Auto",required = true,dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "carApplicationAuto",value = "用车申请单号",required = true,dataType = "long",paramType = "path")
    })
    @GetMapping(value = "queryCheckOne")
    public ResponseResult<CheckOne> queryCheckOne(@RequestParam(name = "loginUserID") Long loginUserID,
                                                  @RequestParam(name = "carApplicationAuto") Long carApplicationAuto){
        CheckOne checkOne = carApplicationService.selectCheckOne(loginUserID,carApplicationAuto);
        if (checkOne == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",checkOne);
    }

    @ApiOperation(value = "用车审核：核准、驳回(此接口如要测试请联系后端)")
    @PostMapping(value = "useCarCheckInsert")
    public ResponseResult<String> UseCarCheckInsert(@ApiParam(value = "用车审核：核准、驳回数据")@Valid @RequestBody UseCarCheckParamDto useCarCheckParamDto){
        UseCarCheckDto useCarCheckDto = new UseCarCheckDto();
        BeanUtils.copyProperties(useCarCheckParamDto,useCarCheckDto);
        Integer i = carApplicationService.useCarCheckInsert(useCarCheckDto);
        if (i == 0){
            if (useCarCheckDto.getAppStatus()==20){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"核准失败",null);
            }
            if (useCarCheckDto.getAppStatus()==5){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"驳回失败",null);
            }
        }
        if (useCarCheckDto.getAppStatus()==20){
            return new ResponseResult<>(ResponseResult.CodeStatus.OK,"核准成功",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"驳回成功",null);
    }

    @ApiOperation(value = "用车审核：更改车辆(此接口如要测试请联系后端)")
    @PutMapping(value = "carChangeUpdate")
    public ResponseResult<String> CarChangeUpdate(@ApiParam(value = "用车审核：更改车辆数据")@Valid @RequestBody CarChangeParamDto carChangeParamDto){
        CarChangeDto carChangeDto = new CarChangeDto();
        BeanUtils.copyProperties(carChangeParamDto,carChangeDto);
        Integer i = carApplicationService.carChangeUpdate(carChangeDto);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"更改失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"更改成功",null);
    }
}
