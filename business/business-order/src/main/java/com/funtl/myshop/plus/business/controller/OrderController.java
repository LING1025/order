package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.SignOffParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.RolesList;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import com.funtl.myshop.plus.provider.dto.RoleList;;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags = "直租、回租试算签核相关操作")
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

    @Reference(version = "1.0.0")
    private OrderService orderService;

    @Reference(version = "1.0.0")
    private WorkFlowDocService workFlowDocService;

    @Reference(version = "1.0.0")
    private AspnetUsersService aspnetUsersService;

    @Reference(version = "1.0.0")
    private ItemCodeService itemCodeService;

    @ApiOperation(value = "根据用户id获取选择权限数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "用户id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryRoleList")
    public ResponseResult<List<RolesList>> queryRoleList(@RequestParam(name = "userAuto",required = false) Long userAuto) {
        List<RoleList> lists1 = itemCodeService.selectByType(1062);
        List<RoleList> lists2 = aspnetUsersService.selectByUserAuto(userAuto);
        List<RolesList> lists = Lists.newArrayList();
        for (RoleList roleList1 : lists1){
            for (RoleList roleList2 : lists2){
                if (roleList2.getRolesAuto() == roleList1.getNum()){
                    RolesList rolesList = new RolesList();
                    rolesList.setRolesAuto(roleList2.getRolesAuto());
                    rolesList.setRoleName(roleList2.getRoleName());
                    lists.add(rolesList);
                }
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 选择操作人：代理人")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "代理人id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryAgentList")
    public ResponseResult<List<AgentList>> queryAgentList(@RequestParam(name = "userAuto",required = false) Long userAuto){
        //代理人id查询
        List<AgentList> lists = creditAgentService.selectAgentList(userAuto);
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
/*    @ApiOperation(value = "选择操作人：本人")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "本人id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "querySelfList")
    public ResponseResult<List<SelfList>> querySelfList(@RequestParam(name = "userAuto",required = false) Long userAuto) {
        List<SelfList> lists = creditAgentService.selectSelfList(userAuto);
        for(SelfList selfList : lists){
            VEmp vEmp = vEmpService.selectByUserAuto(selfList.getSelfUser());
            if (vEmp != null) {
                //获取被代理人角色权限
                List<AspnetRoles> list = aspnetRolesService.selectByUserId(vEmp.getUserId());
                List<SelfRoles> selfRolesList = Lists.newArrayList();
                for (AspnetRoles aspnetRoles : list) {
                    SelfRoles selfRoles = new SelfRoles();
                    selfRoles.setSelfRoleIds(aspnetRoles.getRolesAuto());
                    selfRoles.setSelfRoleNames(aspnetRoles.getRoleName());
                    selfRolesList.add(selfRoles);
                }
                selfList.setSelfRolesList(selfRolesList);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }


    @ApiOperation(value = " 选择操作人：代理人")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "代理人id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryAgentList")
    public ResponseResult<List<AgentList>> queryAgentList(@RequestParam(name = "userAuto",required = false) Long userAuto){
        //代理人id查询
        List<AgentList> lists = creditAgentService.selectAgentList(userAuto);
        for(AgentList agentList : lists){
            VEmp vEmp = vEmpService.selectByUserAuto(agentList.getSelfUser());
            if (vEmp != null){
                agentList.setSelfName(vEmp.getFName() + "_" + vEmp.getDepName());
                //获取被代理人角色权限
                List<AspnetRoles> list = aspnetRolesService.selectByUserId(vEmp.getUserId());
                List<SelfRoles> selfRolesList = Lists.newArrayList();
                for(AspnetRoles aspnetRoles : list){
                    SelfRoles selfRoles = new SelfRoles();
                    selfRoles.setSelfRoleIds(aspnetRoles.getRolesAuto());
                    selfRoles.setSelfRoleNames(aspnetRoles.getRoleName());
                    selfRolesList.add(selfRoles);
                }
                agentList.setSelfRolesList(selfRolesList);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }*/

    @ApiOperation(value = " 根据角色id集合获取主档信息待签核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleIds", value = "角色id集合", required = false, dataType = "List<Long>", paramType = "path")
    })
    @GetMapping(value = "queryMasterList")
    public ResponseResult<List<MasterList>> queryMasterList(@RequestParam(name = "roleIds",required = false) List<Long> roleIds){
        if (roleIds == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        List<MasterList> lists = ordersService.selectByRoleIds(roleIds);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 获取试算直租签核外部所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryOrdersList")
    public ResponseResult<OrdersList> queryOrdersList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        OrdersList ordersList = ordersService.selectByOrdersAuto(ordersAuto);
        ordersList.setFName(ordersList.getFName() + " " + ordersList.getTradeItemAuto());
        ordersList.setFactoryBrandName(ordersList.getFactoryBrandName() + " " + ordersList.getBrandName() + " " + ordersList.getClasenName());
        ordersList.setOverAmtYName(ordersList.getOverAmtY() + " " + ordersList.getOverP());
        ordersList.setDptAmtName(ordersList.getDptAmt() + "(" + ordersList.getDptTypeName() + ")" + ordersList.getDptP());
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", ordersList);
    }

    @ApiOperation(value = " 获取回租试算签核外部所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryOrdersBackList")
    public ResponseResult<OrdersBackList> queryOrdersBackList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        OrdersBackList ordersBackList = ordersService.selectOrdersBackList(ordersAuto);
        //GPS安装
        if(ordersBackList.getGpsAmt().compareTo(BigDecimal.valueOf(0)) == 1){
            ordersBackList.setGps(1);
        }else{
            ordersBackList.setGps(0);
        }
        //贷款金额与贷款成数的计算公式
        Double dFee = (ordersBackList.getInsureRealAmt().add(ordersBackList.getAccessary().add(ordersBackList.getFeeAmt()
                        .add(ordersBackList.getCarTax().add(ordersBackList.getFinanceFee().add(ordersBackList.getUrgentFee()
                        .add(ordersBackList.getOutFee().add(ordersBackList.getCarExtensionAmt())))))))).doubleValue();
        Double p = ((ordersBackList.getRentAmt().subtract(ordersBackList.getStampTax())).doubleValue())*1.0/
                ((ordersBackList.getListPrice().subtract(ordersBackList.getDisPrice())).doubleValue() + dFee);
        ordersBackList.setAmtP(ordersBackList.getRentAmt().subtract(ordersBackList.getStampTax()).toString()
                                + "(" + Math.round(p*100) + "%)");
        //折价金额
        ordersBackList.setDisPriceN(ordersBackList.getDisPrice()+"  "+ordersBackList.getGetPrice());
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", ordersBackList);
    }

    @ApiOperation(value = " 根据试算单号获取保险内容(未点开时显示的)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryInsuranceContentList")
    public ResponseResult<List<InsuranceContentList>> queryInsuranceContentList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
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
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
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
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
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
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        List<SignOffList> lists = ordersFDetailService.selectSignOffList(ordersAuto);
        for(SignOffList signOffList : lists){
            switch (signOffList.getOrdersStatus()){
                case 23:
                    signOffList.setOrdersStatusName("已审核");
                    signOffList.setCreditPerson("系统自动审核");
                    break;
                case 22:
                    signOffList.setOrdersStatusName("核准");
                    break;
                case 21:
                    signOffList.setOrdersStatusName("已审核(跨签)");
                    break;
                case 1:
                    signOffList.setOrdersStatusName("作废");
                    break;
                case 5:
                    signOffList.setOrdersStatusName("驳回");
                    break;
                case 20:
                    signOffList.setOrdersStatusName("已审核");
                    break;
                case 0:
                    signOffList.setOrdersStatusName("未审核");
                    break;
                default:
                    signOffList.setOrdersStatusName("");
                    break;
            }
            if (signOffList.getIsAgent() == 1){
                signOffList.setCreditPerson(signOffList.getCreditPerson() + "(代理)");
            }
            if(signOffList.getCdt() == null){
                signOffList.setCdtTime("");
            }
            if(signOffList.getCdt() != null){
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(signOffList.getCdt());
                signOffList.setCdtTime(dateString);
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
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
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
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
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
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
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
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        List<CommissionList> lists = commissionService.selectCommissionList(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 根据试算单号获取报价车商历史成交记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "querySupplierList")
    public ResponseResult<List<SupplierList>> querySupplierList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        List<SupplierList> lists = ordersService.selectSupplierList(ordersAuto);
        for(SupplierList supplierList : lists){
            if(supplierList.getBookDT() == null){
                supplierList.setBookTime("");
            }
            if(supplierList.getBookDT() !=null ){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dataString = simpleDateFormat.format(supplierList.getBookDT());
                supplierList.setBookTime(dataString);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 根据试算单号获取报价车型历史成交记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryClasenList")
    public ResponseResult<List<ClasenList>> queryClasenList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        List<ClasenList> lists = orderService.selectClasenList(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "签核")
    @PostMapping(value = "insertSignOff")
    public ResponseResult<String> insertSignOff(@ApiParam(value = "签核数据") @Valid @RequestBody SignOffParamDto signOffParamDto){
        if(signOffParamDto.getOrdersFDetailAuto() != 0){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);
        }
        SignOffList signOffList = workFlowDocService.selectByDocPostIDAndRoleId(signOffParamDto.getOrdersAuto(),signOffParamDto.getRoleId());
        if(signOffList == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无信息", null);
        }
        OrdersFDetail ordersFDetail = new OrdersFDetail();
        BeanUtils.copyProperties(signOffParamDto,ordersFDetail);
        ordersFDetail.setCdt(new Date());
        ordersFDetail.setMdt(new Date());
        if(signOffParamDto.getCreditPerson().equals(signOffParamDto.getAgentPerson())){
            ordersFDetail.setIsAgent(0);
        }else{
            ordersFDetail.setIsAgent(1);
        }
        ordersFDetail.setOrdersStatus(20);
        Long i = ordersFDetailService.insert(ordersFDetail);
        if(i == 0){
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
        }

        Integer j = workFlowDocService.deleteById(signOffList.getWorkFlowDocAuto());
        if (j == 0){
            ordersFDetailService.deleteById(i);
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "保存成功", null);
    }

    @ApiOperation(value = "驳回")
    @PostMapping(value = "insertTurnDown")
    public ResponseResult<String> insertTurnDown(@ApiParam(value = "驳回数据") @Valid @RequestBody SignOffParamDto signOffParamDto){
        if(signOffParamDto.getOrdersFDetailAuto() != 0){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);
        }
        SignOffList signOffList = workFlowDocService.selectByDocPostIDAndRoleId(signOffParamDto.getOrdersAuto(),signOffParamDto.getRoleId());
        if(signOffList == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无信息", null);
        }
        OrdersFDetail ordersFDetail = new OrdersFDetail();
        BeanUtils.copyProperties(signOffParamDto,ordersFDetail);
        ordersFDetail.setCdt(new Date());
        ordersFDetail.setMdt(new Date());
        if(signOffParamDto.getCreditPerson().equals(signOffParamDto.getAgentPerson())){
            ordersFDetail.setIsAgent(0);
        }else{
            ordersFDetail.setIsAgent(1);
        }
        ordersFDetail.setOrdersStatus(5);
        Long i = ordersFDetailService.insert(ordersFDetail);
        if(i == 0){
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
        }

        Integer j = workFlowDocService.deleteById(signOffList.getWorkFlowDocAuto());
        if (j == 0){
            ordersFDetailService.deleteById(i);
            throw new BusinessException(BusinessStatus.SAVE_FAILURE);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "保存成功", null);
    }

}
