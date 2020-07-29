package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
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

    @Reference(version = "1.0.0")
    private OrdersInsureListService ordersInsureListService;

    @Reference(version = "1.0.0")
    private OrdersInsureYearsService ordersInsureYearsService;

    @Reference(version = "1.0.0")
    private OrdersFDetailService ordersFDetailService;

    @Reference(version = "1.0.0")
    private OrdersBudgetService ordersBudgetService;

    @Reference(version = "1.0.0")
    private OrdersFeeService ordersFeeService;

    @Reference(version = "1.0.0")
    private OrdersAccessaryService ordersAccessaryService;

    @Reference(version = "1.0.0")
    private CommissionService commissionService;

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
                List<SelfRoles> selfRolesList = Lists.newArrayList();
                for(AspnetRoles aspnetRoles : list){
                    SelfRoles selfRoles = new SelfRoles();
                    selfRoles.setSelfRoleIds(aspnetRoles.getRolesAuto());
                    selfRoles.setSelfRoleNames(aspnetRoles.getRoleName());
                    selfRolesList.add(selfRoles);
                }
                dto.setSelfRolesList(selfRolesList);
            }
            VEmp vEmp2 = vEmpService.selectByUserAuto(dto.getAgentUser());
            if (vEmp2 != null){
                dto.setAgentName(vEmp2.getFName());
                dto.setAgentDept(vEmp2.getDepName());
                //获取代理人角色权限
                List<AspnetRoles> list = aspnetRolesService.selectByUserId(vEmp2.getUserId());
                List<AgentRoles> agentRolesList = Lists.newArrayList();
                for(AspnetRoles aspnetRoles : list){
                    AgentRoles agentRoles = new AgentRoles();
                    agentRoles.setAgentRoleIds(aspnetRoles.getRolesAuto());
                    agentRoles.setAgentRoleNames(aspnetRoles.getRoleName());
                    agentRolesList.add(agentRoles);
                }
                dto.setAgentRolesList(agentRolesList);
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
                //获取代理人角色权限
                List<AspnetRoles> list = aspnetRolesService.selectByUserId(vEmp.getUserId());
                List<AgentRoles> agentRolesList = Lists.newArrayList();
                for(AspnetRoles aspnetRoles : list){
                    AgentRoles agentRoles = new AgentRoles();
                    agentRoles.setAgentRoleIds(aspnetRoles.getRolesAuto());
                    agentRoles.setAgentRoleNames(aspnetRoles.getRoleName());
                    agentRolesList.add(agentRoles);
                }
                dto.setAgentRolesList(agentRolesList);
            }
            VEmp vEmp2 = vEmpService.selectByUserAuto(dto.getSelfUser());
            if (vEmp2 != null){
                dto.setSelfName(vEmp2.getFName());
                dto.setSelfDept(vEmp2.getDepName());
                //获取本人角色权限
                List<AspnetRoles> list = aspnetRolesService.selectByUserId(vEmp2.getUserId());
                List<SelfRoles> selfRolesList = Lists.newArrayList();
                for(AspnetRoles aspnetRoles : list){
                    SelfRoles selfRoles = new SelfRoles();
                    selfRoles.setSelfRoleIds(aspnetRoles.getRolesAuto());
                    selfRoles.setSelfRoleNames(aspnetRoles.getRoleName());
                    selfRolesList.add(selfRoles);
                }
                dto.setSelfRolesList(selfRolesList);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", pageInfo);
    }

    @ApiOperation(value = " 根据角色id集合获取主档信息待签核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleIds", value = "角色id集合", required = false, dataType = "List<Long>", paramType = "path")
    })
    @GetMapping(value = "queryMasterList")
    public ResponseResult<List<MasterList>> queryMasterList(@RequestParam(name = "roleIds",required = false) List<Long> roleIds){
        if (roleIds == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        List<MasterList> lists = ordersService.selectByRoleIds(roleIds);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 根据试算单号获取试算签核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryOrdersList")
    public ResponseResult<OrdersList> queryOrdersList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        OrdersList ordersList = ordersService.selectByOrdersAuto(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", ordersList);
    }

    @ApiOperation(value = " 根据试算单号获取保险内容(未点开时显示的)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryInsuranceContentList")
    public ResponseResult<List<InsuranceContentList>> queryInsuranceContentList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        List<InsuranceContentList> lists = ordersInsureListService.selectInsuranceContentList(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 根据试算单号获取保险明细上部分信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryInsuranceList")
    public ResponseResult<InsuranceList> queryInsuranceList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        InsuranceList insuranceList = ordersInsureYearsService.selectInsuranceList(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", insuranceList);
    }

    @ApiOperation(value = " 根据试算单号和年份获取保单明细(点开后的表格)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "insureYear", value = "年度", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryInsuranceTableList")
    public ResponseResult<List<InsuranceTableList>> queryInsuranceTableList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto,
                                                                       @RequestParam(name = "insureYear",required = false) Integer insureYear){
        if (ordersAuto == null || insureYear == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        List<InsuranceTableList> lists = ordersInsureYearsService.selectByOrdersAutoAndYear(ordersAuto,insureYear);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 根据试算单号获取签核明细数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "querySignOffList")
    public ResponseResult<List<SignOffList>> querySignOffList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        List<SignOffList> lists = ordersFDetailService.selectSignOffList(ordersAuto);
        for(SignOffList signOffList : lists){
            if (signOffList.getIsAgent() == 1){
                signOffList.setOrderStatusName(signOffList.getOrderStatusName() + "(代理)");
            }
            if (signOffList.getRoleId() != null){
                AspnetRoles aspnetRoles = aspnetRolesService.selectByRoleAuto(signOffList.getRoleId());
                signOffList.setRoleName(aspnetRoles.getRoleName());
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 根据试算单号获取其他费用明细数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryBudgetList")
    public ResponseResult<List<BudgetList>> queryBudgetList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        List<BudgetList> lists = ordersBudgetService.selectBudgetList(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 根据试算单号获取上牌规费明细数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryFeeList")
    public ResponseResult<List<FeeList>> queryFeeList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        List<FeeList> lists = ordersFeeService.selectFeeList(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 根据试算单号获取配件明细数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryAccessoryList")
    public ResponseResult<List<AccessoryList>> queryAccessoryList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        List<AccessoryList> lists = ordersAccessaryService.selectAccessoryList(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 根据试算单号获取佣金明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryCommissionList")
    public ResponseResult<List<CommissionList>> queryCommissionList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        List<CommissionList> lists = commissionService.selectCommissionList(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

}
