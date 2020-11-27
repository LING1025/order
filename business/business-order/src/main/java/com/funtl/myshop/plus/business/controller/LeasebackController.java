package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.LeasebackQueryParam;
import com.funtl.myshop.plus.provider.dto.SupplierNamesDto;
import com.funtl.myshop.plus.provider.dto.SupplierQueryParam;
import com.github.pagehelper.PageInfo;
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
import java.math.BigDecimal;
import java.util.List;

@Api(tags = "回租报价相关操作")
@RestController
@RequestMapping(value = "leaseback")
public class LeasebackController implements Serializable {
    @Reference(version = "1.0.0")
    private OrdersService ordersService;

    @Reference(version = "1.0.0")
    private ItemCodeService itemCodeService;

    @Reference(version = "1.0.0")
    private VEmp2RoleService vEmp2RoleService;

    @Reference(version = "1.0.0")
    private FactoryBrandService factoryBrandService;

    @Reference(version = "1.0.0")
    private BrandService brandService;

    @Reference(version = "1.0.0")
    private OrdersStepwiseService ordersStepwiseService;

    @Reference(version = "1.0.0")
    private OrdersInsureListService ordersInsureListService;

    @Reference(version = "1.0.0")
    private OrdersInsureYearsService ordersInsureYearsService;

    /**
     * 回租报价
     */

    @ApiOperation(value = "回租报价：下拉选")
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

    @ApiOperation(value = "回租报价：1、承办业代部门下拉选")
    @ApiImplicitParam(name = "userAuto", value = "登录者userAuto", required = true, dataType = "long", paramType = "path")
    @GetMapping(value = "queryOrgName")
    public ResponseResult<List<OrgNameSelect>> queryOrgName(@RequestParam(name = "userAuto")Long userAuto){
        List<OrgNameSelect> list = vEmp2RoleService.selectOrgName(userAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "回租报价：2、承办业代姓名下拉选")
    @ApiImplicitParam(name = "orgAuto", value = "部门序号", required = false, dataType = "long", paramType = "path")
    @GetMapping(value = "queryFName")
    public ResponseResult<List<FNameSelect>> queryFName(/*@RequestParam(name = "roleName")String roleName,*/
                                                        @RequestParam(name = "orgAuto")Long orgAuto){
        List<FNameSelect> list = vEmp2RoleService.selectFName("業務員",orgAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "回租报价：1、总厂牌下拉选")
    @GetMapping(value = "queryFactoryBrandName")
    public ResponseResult<List<FactoryBrandNameSelect>> queryFactoryBrandName(){
        List<FactoryBrandNameSelect> list = factoryBrandService.selectFactoryBrandName();
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "回租报价：2、厂牌下拉选")
    @ApiImplicitParam(name = "factoryBrandAuto", value = "总厂牌序号", required = false, dataType = "long", paramType = "path")
    @GetMapping(value = "queryBrandName")
    public ResponseResult<List<BrandNameSelect>> queryBrandName(@RequestParam(name = "factoryBrandAuto")Long factoryBrandAuto){
        List<BrandNameSelect> list = brandService.selectBrandName(factoryBrandAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "回租报价：3、车型下拉选")
    @ApiImplicitParam(name = "brandAuto", value = "厂牌序号", required = false, dataType = "long", paramType = "path")
    @GetMapping(value = "queryClasenName")
    public ResponseResult<List<ClasenNameSelect>> queryClasenName(@RequestParam(name = "brandAuto")Long brandAuto){
        List<ClasenNameSelect> list = brandService.selectClasenName(brandAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "回租报价：报价车商列表分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchWord", value = "查询条件", required = false, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageIndex", value = "当前要求的页码索引", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "querySupplierNames")
    public ResponseResult<PageInfo<SupplierNamesDto>> querySupplierNames(@RequestParam(name = "searchWord", required = false) String searchWord,
                                                                         @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                                                         @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @RequestParam(name = "pageIndex", defaultValue = "1") Integer pageIndex){
        SupplierQueryParam supplierQueryParam = new SupplierQueryParam(3,searchWord,pageNum,pageSize,pageIndex);
        PageInfo<SupplierNamesDto> pageInfo = ordersService.selectSupplierNames(supplierQueryParam);
        if (pageInfo.getList().size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无数据！", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", pageInfo);
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

    //贷款金额与贷款成数的计算公式
    public static double calculatePMT(double rate, double nper, double pv) {
        double v = (1 + (rate /100 / 12));
        double t = (-(nper / 12) * 12);
        double result = (pv * (rate /100 / 12)) / (1 - Math.pow(v, t));
        return result;
    }

    @ApiOperation(value = "回租报价：单号获取数据")
    @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    @GetMapping(value = "queryLeasebacks")
    public ResponseResult<Leasebacks> queryLeasebacks(@RequestParam(name = "ordersAuto",defaultValue = "0") Long ordersAuto){
        Leasebacks leasebacks = ordersService.selectLeasebacks(ordersAuto);
        if (leasebacks == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查询条件无资料", null);
        }

        if (leasebacks.getTaxMode() == 5){
            leasebacks.setTaxMode(6);
        }
        //退税年化利率计算
        double rentRateY = (calculatePMT(leasebacks.getRentRate().doubleValue(), leasebacks.getMm(), 1) * leasebacks.getMm()-1)*100*12/leasebacks.getMm();
        //四舍五入保留两位小数
        BigDecimal bg = new BigDecimal(rentRateY);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        leasebacks.setRentRateY(f1+"%");
        //GPS安装
        if(leasebacks.getGpsAmt().compareTo(BigDecimal.valueOf(0)) == 1){
            leasebacks.setGps(1);
        }else{
            leasebacks.setGps(0);
        }
        //贷款金额与贷款成数的计算公式
        double dFee = (leasebacks.getInsureRealAmt().add(leasebacks.getAccessary().add(leasebacks.getFeeAmt()
                .add(leasebacks.getCarTax().add(leasebacks.getFinanceFee().add(leasebacks.getUrgentFee()
                        .add(leasebacks.getOutFee().add(leasebacks.getCarExtensionAmt())))))))).doubleValue();
        double p = ((leasebacks.getRentAmt().subtract(leasebacks.getStampTax())).doubleValue())*1.0/
                ((leasebacks.getListPrice().subtract(leasebacks.getDisPrice())).doubleValue() + dFee);
        Integer amtP = Math.round(leasebacks.getRentAmt().subtract(leasebacks.getStampTax()).intValue());
        leasebacks.setAmtPNum(Math.round(p*100));
        leasebacks.setAmtP(amtP + "(" + Math.round(p*100) + "%)");
        //客户全称
//        leasebacks.setFName(leasebacks.getFName()+ " "+ leasebacks.getTradeItemAuto()+ " " + leasebacks.getCustomerStatus());

        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", leasebacks);
    }

    @ApiOperation(value = "回租报价：阶梯式租金")
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

    @ApiOperation(value = "回租报价：保险金额")
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

    @ApiOperation(value = "回租报价：保险金额点开后的保险明细")
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
}
