package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.LeasebackQueryParam;
import com.funtl.myshop.plus.provider.dto.RolesList;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import com.funtl.myshop.plus.provider.dto.RoleList;;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

@Api(tags = "直租、回租试算签核相关查询操作")
@RestController
@RequestMapping(value = "order")
public class OrderController {
    @Reference(version = "1.0.0")
    private CreditAgentService creditAgentService;

    @Reference(version = "1.0.0")
    private VEmpService vEmpService;

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

    @Reference(version = "1.0.0")
    private OrdersStepwiseService ordersStepwiseService;

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

    @ApiOperation(value = " 根据选择角色权限id、选择代理人id获取主档信息待签核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rolesAuto", value = "角色id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "userAuto", value = "代理人id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryMasterList")
    public ResponseResult<List<MasterList>> queryMasterList(@RequestParam(name = "rolesAuto",required = false) Long rolesAuto,
                                                            @RequestParam(name = "userAuto",required = false) Long userAuto){
        if (rolesAuto == null || userAuto == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        List<MasterList> lists = ordersService.selectByRoleIds(rolesAuto,userAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 根据选择角色权限id、选择代理人id获取可跨阶签核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rolesAuto", value = "角色id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "userAuto", value = "代理人id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryCrossList")
    public ResponseResult<List<MasterList>> queryCrossList(@RequestParam(name = "rolesAuto",required = false) Long rolesAuto,
                                                            @RequestParam(name = "userAuto",required = false) Long userAuto){
        if (rolesAuto == null || userAuto == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        List<MasterList> lists = ordersService.selectCrossList(rolesAuto,userAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    //贷款金额与贷款成数的计算公式
    public static double calculatePMT(double rate, double nper, double pv) {
        double v = (1 + (rate /100 / 12));
        double t = (-(nper / 12) * 12);
        double result = (pv * (rate /100 / 12)) / (1 - Math.pow(v, t));
        return result;
    }

    @ApiOperation(value = " 获取直租试算签核外部所有信息")//获取直租试算签核外部所有信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryOrdersList")
    public ResponseResult<OrdersList> queryOrdersList(@RequestParam(name = "ordersAuto",defaultValue = "0") Long ordersAuto){
        OrdersList ordersList = ordersService.selectOrdersList(ordersAuto);
        if(ordersList == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查询条件无资料", null);
        }
        //判断试算单号框外面显示的值
        MsgDto msgDto = ordersService.selectMsg(ordersAuto);
        if (msgDto != null){
            ordersList.setMsg(msgDto.getMsg());
        }else{
            ordersList.setMsg("");
        }


        //介绍人+手机号码
        ordersList.setPushMan(ordersList.getPushMan() + ordersList.getPushTel());

        //车号
        ordersList.setMakNo(ordersList.getMakNo() + ordersList.getCarBaseAuto());

        //保险内容框标题后的显示
        if (ordersList.getIsCustomerCare() != 2 && ordersList.getIsCustomerCare() != 0){
            ordersList.setInsureIsOffer(ordersList.getCustomerCareName());
        }else{
            ordersList.setInsureIsOffer("");
        }

        //上牌规费明细表上面一句话的赋值
        ordersList.setBudgetMemo("");
        if (ordersList.getBudget01Y().toString() != "" && ordersList.getBudget01Y().doubleValue() != 0){
            List<OrdersBudget> list = ordersBudgetService.selectByOrdersAndPa(ordersAuto,ordersList.getBudget01Y());
            if (list.size() > 0){
                ordersList.setBudgetMemo("保养维修费与设定金额不符！原保养维修费为：" + ordersList.getBudget01Y());
            }
        }

        //签核明细表标题后的字
        if (ordersList.getOnetime() == 1){
            ordersList.setOnetimeName("(一次性租赁)");
        }else{
            ordersList.setOnetimeName("");
        }

        //保险成本(年)
//        ordersList.setInsureYG("保险成本(年) : "+ordersList.getInsureRealAmt());
        //客户全称
        ordersList.setFName(ordersList.getFName() + " " + ordersList.getTradeItemAuto() + " " + ordersList.getCustomerStatus());
        //厂牌车型
        ordersList.setFactoryBrandName(ordersList.getFactoryBrandName() + " " + ordersList.getBrandName() + " " + ordersList.getClasenName());

        //残值比例计算
        if (ordersList.getCarSource() == 1 || ordersList.getCarSource() == 4){
            ordersList.setOverP(Math.round(ordersList.getOverAmt().doubleValue()/ordersList.getGetPrice().doubleValue()*100) + "%");
        }else {
            ordersList.setOverP(Math.round(ordersList.getOverAmt().doubleValue()/ordersList.getListPrice().doubleValue()*100) + "%");
        }
        //残值
        ordersList.setOverAmtYName(ordersList.getOverP());
        //保证金
        ordersList.setDptAmtName(Math.round(ordersList.getDptAmt().intValue()) + "(" + ordersList.getDptTypeName() + ordersList.getDptTaxPayN()+")" + ordersList.getDptP());

        //租金计算

        ordersList.setRateMAmt(ordersList.getRateAmt().add(ordersList.getRateTax()));
        ordersList.setRTRentRate(ordersList.getRateRate());
        ordersList.setRentMAmt(ordersList.getMAmt());
        ordersList.setFMAmt(ordersList.getRentMAmt());
        ordersList.setFRentRate(ordersList.getFinalRate());

        //计价成本竖列第9计算
        double d1 = (calculatePMT(ordersList.getRateRate().doubleValue(), ordersList.getMm(), 1) * ordersList.getMm()-1)*100*12/ordersList.getMm();
        //四舍五入保留两位小数
        BigDecimal bg = new BigDecimal(d1);
        ordersList.setRTRentRateY(bg.setScale(2, BigDecimal.ROUND_HALF_UP));

        //成交利率竖列第9计算
        double d2 = (calculatePMT(ordersList.getRentRate().doubleValue(), ordersList.getMm(), 1) * ordersList.getMm()-1)*100*12/ordersList.getMm();
        //四舍五入保留两位小数
        BigDecimal bg2 = new BigDecimal(d2);
        ordersList.setRentRateYa(bg2.setScale(2, BigDecimal.ROUND_HALF_UP));

        //实际成交价竖列第9计算
        double d3 = (calculatePMT(ordersList.getFinalRate().doubleValue(), ordersList.getMm(), 1) * ordersList.getMm()-1)*100*12/ordersList.getMm();
        //四舍五入保留两位小数
        BigDecimal bg3 = new BigDecimal(d3);
        ordersList.setFRentRateY(bg3.setScale(2, BigDecimal.ROUND_HALF_UP));

        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", ordersList);
    }

    @ApiOperation(value = "回租报价：获取回租信息")//获取回租试算签核外部所有信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryOrdersBackList")
    public ResponseResult<OrdersBackList> queryOrdersBackList(@RequestParam(name = "ordersAuto",defaultValue = "0") Long ordersAuto){
        OrdersBackList ordersBackList = ordersService.selectOrdersBackList(ordersAuto);
        if(ordersBackList == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查询条件无资料", null);
        }
        if (ordersBackList.getTaxMode() == 5){
            ordersBackList.setTaxMode(6);
        }
        //已用里程
        ordersBackList.setUseKmN(ordersBackList.getUsekm()+"公里");
        //退税年化利率计算
        double rentRateY = (calculatePMT(ordersBackList.getRentRate().doubleValue(), ordersBackList.getMm(), 1) * ordersBackList.getMm()-1)*100*12/ordersBackList.getMm();
        //四舍五入保留两位小数
        BigDecimal bg = new BigDecimal(rentRateY);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        ordersBackList.setRentRateY(f1+"%");
        //GPS安装
        if(ordersBackList.getGpsAmt().compareTo(BigDecimal.valueOf(0)) == 1){
            ordersBackList.setGps(1);
        }else{
            ordersBackList.setGps(0);
        }
        //贷款金额与贷款成数的计算公式
        double dFee = (ordersBackList.getInsureRealAmt().add(ordersBackList.getAccessary().add(ordersBackList.getFeeAmt()
                        .add(ordersBackList.getCarTax().add(ordersBackList.getFinanceFee().add(ordersBackList.getUrgentFee()
                        .add(ordersBackList.getOutFee().add(ordersBackList.getCarExtensionAmt())))))))).doubleValue();
        double p = ((ordersBackList.getRentAmt().subtract(ordersBackList.getStampTax())).doubleValue())*1.0/
                ((ordersBackList.getListPrice().subtract(ordersBackList.getDisPrice())).doubleValue() + dFee);
        Integer amtP = Math.round(ordersBackList.getRentAmt().subtract(ordersBackList.getStampTax()).intValue());
        ordersBackList.setAmtP(amtP + "(" + Math.round(p*100) + "%)");
        //折价金额
        ordersBackList.setDisPriceN(ordersBackList.getDisPrice()+"  "+ordersBackList.getGetPrice());
        //客户全称
        ordersBackList.setFName(ordersBackList.getFName()+ " "+ ordersBackList.getTradeItemAuto()+ " " + ordersBackList.getCustomerStatus() + " " + ordersBackList.getIsBigTra());
        //厂牌车型
        ordersBackList.setFactoryBrandName(ordersBackList.getFactoryBrandName() + " " + ordersBackList.getBrandName() + " " + ordersBackList.getClasenName());

        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", ordersBackList);
    }

    @ApiOperation(value = " 根据试算单号获取付款条件信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryStepwiseList")
    public ResponseResult<List<StepwiseList>> queryStepwiseList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        List<StepwiseList> lists = ordersStepwiseService.selectByOrdersAuto(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
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

    @ApiOperation(value = " (直租)根据试算单号获取上牌规费明细数据")
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

    @ApiOperation(value = " (回租)根据试算单号获取上牌规费明细数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryFeeBackList")
    public ResponseResult<List<FeeList>> queryFeeBackList(@RequestParam(name = "ordersAuto",required = false) Long ordersAuto){
        if (ordersAuto == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        List<FeeList> lists = ordersFeeService.selectFeeBackList(ordersAuto);
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

    @ApiOperation(value = " 根据试算单号集合获取异常佣金人佣金记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号集合", required = false, dataType = "List<Long>", paramType = "path")
    })
    @GetMapping(value = "queryCommissionRecordList")
    public ResponseResult<List<CommissionRecordList>> queryCommissionRecordList(@RequestParam(name = "ordersAuto",required = false) List<Long> ordersAuto){
        List<CommissionRecordList> lists = commissionService.selectRecord(ordersAuto);
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
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
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

    @ApiOperation(value = " 试算签核验证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "docPostID", value = "试算单号", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "roleId", value = "角色id", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryWorkFlowDoc")
    public ResponseResult<List<WorkFlowDoc>> queryWorkFlowDoc(@RequestParam(name = "docPostID",required = false) Long docPostID,
                                                              @RequestParam(name = "roleId",required = false) Integer roleId){
        if (docPostID == null || roleId == null){
            throw new BusinessException(BusinessStatus.PARAM_ERROR);        }
        List<WorkFlowDoc> lists = workFlowDocService.selectWorkFlowDoc(docPostID,roleId,1);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    /**
     * 回租报价
     */

    @ApiOperation(value = "回租报价：下拉选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemType", value = "413回租报价", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "num", value = "对应的num", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryItemNames")
    public ResponseResult<List<LeasebackSelect>> queryItemNames(@RequestParam(name = "itemType")Integer itemType,
                                                          @RequestParam(name = "num", defaultValue = "100")Long num){
        List<LeasebackSelect> leasebackSelects = itemCodeService.selectItemName(itemType,num);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", leasebackSelects);
    }

    @ApiOperation(value = " 回租报价：查询按钮")
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
