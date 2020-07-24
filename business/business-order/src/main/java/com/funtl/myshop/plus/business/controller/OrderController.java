package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.AspnetRolesService;
import com.funtl.myshop.plus.provider.api.CreditAgentService;
import com.funtl.myshop.plus.provider.api.OrdersService;
import com.funtl.myshop.plus.provider.api.VEmpService;
import com.funtl.myshop.plus.provider.domain.AspnetRoles;
import com.funtl.myshop.plus.provider.domain.MasterList;
import com.funtl.myshop.plus.provider.domain.SelfAgentList;
import com.funtl.myshop.plus.provider.domain.VEmp;
import com.github.pagehelper.PageInfo;
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

import java.util.List;

@Api(tags = "签核试算相关操作")
@RestController
@RequestMapping(value = "order")
public class OrderController {
    @Reference(version = "1.0.0")
    private CreditAgentService creditAgentService;

    @Reference(version = "1.0.0")
    private VEmpService vEmpService;

    @Reference(version = "1.0.0")
    private AspnetRolesService aspnetRolesService;

    @Reference(version = "1.0.0")
    private OrdersService ordersService;

    @ApiOperation(value = " 根据本人id获取代理数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "本人id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryBySelf")
    public ResponseResult<List<SelfAgentList>> queryBySelf(@RequestParam(name = "userAuto",required = false) Long userAuto){
        //本人姓名查询
        List<SelfAgentList> pageInfo = creditAgentService.selectSelf(userAuto);
        for(SelfAgentList dto : pageInfo){
            VEmp vEmp = vEmpService.selectByUserAuto(dto.getSelfUser());
            if (vEmp != null){
                dto.setSelfName(vEmp.getFName());
                dto.setSelfDept(vEmp.getDepName());
                //获取本人角色权限
                List<AspnetRoles> list = aspnetRolesService.selectByUserId(vEmp.getUserId());
                List<Long> ids = Lists.newArrayList();
                List<String> names = Lists.newArrayList();
                for(AspnetRoles aspnetRoles : list){
                    ids.add(aspnetRoles.getRolesAuto());
                    names.add(aspnetRoles.getRoleName());
                }
                dto.setSelfRoleIds(ids);
                dto.setSelfRoleNames(names);
            }
            VEmp vEmp2 = vEmpService.selectByUserAuto(dto.getAgentUser());
            if (vEmp2 != null){
                dto.setAgentName(vEmp2.getFName());
                dto.setAgentDept(vEmp2.getDepName());
                //获取代理人角色权限
                List<AspnetRoles> list = aspnetRolesService.selectByUserId(vEmp2.getUserId());
                List<Long> ids = Lists.newArrayList();
                List<String> names = Lists.newArrayList();
                for(AspnetRoles aspnetRoles : list){
                    ids.add(aspnetRoles.getRolesAuto());
                    names.add(aspnetRoles.getRoleName());
                }
                dto.setAgentRoleIds(ids);
                dto.setAgentRoleNames(names);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", pageInfo);
    }

    @ApiOperation(value = " 根据代理人id获取代理数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "代理人id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryByAgent")
    public ResponseResult<List<SelfAgentList>> queryByAgent(@RequestParam(name = "userAuto",required = false) Long userAuto){
        //代理人姓名查询
        List<SelfAgentList> pageInfo = creditAgentService.selectAgent(userAuto);
        for(SelfAgentList dto : pageInfo){
            VEmp vEmp = vEmpService.selectByUserAuto(dto.getAgentUser());
            if (vEmp != null){
                dto.setAgentName(vEmp.getFName());
                dto.setAgentDept(vEmp.getDepName());
                //获取本人角色权限
                List<AspnetRoles> list = aspnetRolesService.selectByUserId(vEmp.getUserId());
                List<Long> ids = Lists.newArrayList();
                List<String> names = Lists.newArrayList();
                for(AspnetRoles aspnetRoles : list){
                    ids.add(aspnetRoles.getRolesAuto());
                    names.add(aspnetRoles.getRoleName());
                }
                dto.setSelfRoleIds(ids);
                dto.setSelfRoleNames(names);
            }
            VEmp vEmp2 = vEmpService.selectByUserAuto(dto.getSelfUser());
            if (vEmp2 != null){
                dto.setSelfName(vEmp2.getFName());
                dto.setSelfDept(vEmp2.getDepName());
                //获取代理人角色权限
                List<AspnetRoles> list = aspnetRolesService.selectByUserId(vEmp2.getUserId());
                List<Long> ids = Lists.newArrayList();
                List<String> names = Lists.newArrayList();
                for(AspnetRoles aspnetRoles : list){
                    ids.add(aspnetRoles.getRolesAuto());
                    names.add(aspnetRoles.getRoleName());
                }
                dto.setAgentRoleIds(ids);
                dto.setAgentRoleNames(names);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", pageInfo);
    }

    @ApiOperation(value = " 根据角色id集合获取主档信息待签核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleIds", value = "角色id集合", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryMasterList")
    public ResponseResult<List<MasterList>> queryMasterList(@RequestParam(name = "roleIds",required = false) List<Long> roleIds){
        if (roleIds == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        List<MasterList> lists = ordersService.selectByRoleIds(roleIds);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

}
