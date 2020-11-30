package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.CopyOrdersParamDto;
import com.funtl.myshop.plus.business.dto.CrmArrangeInsertParamDto;
import com.funtl.myshop.plus.business.dto.ShareBtn;
import com.funtl.myshop.plus.business.dto.ShareBtnParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

    @Reference(version = "1.0.0")
    private OrdersFDetailService ordersFDetailService;

    /**
     * 回租报价
     */

    @ApiOperation(value = "回租报价：下拉选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemType", value = "413回租报价，326业务类别，313客户来源，135抵押地，841排档方式，231燃油种类，316付款条件中的月份", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "num", value = "对应的num", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryItemNames")
    public ResponseResult<List<LeasebackSelect>> queryItemNames(@RequestParam(name = "itemType") Integer itemType,
                                                                @RequestParam(name = "num", defaultValue = "100") Long num) {
        List<LeasebackSelect> leasebackSelects = itemCodeService.selectItemName(itemType, num);
        if (leasebackSelects.size() == 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无资料，请输入其它查询条件!", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", leasebackSelects);
    }

    @ApiOperation(value = "回租报价：1、承办业代部门下拉选")
    @ApiImplicitParam(name = "userAuto", value = "登录者userAuto", required = true, dataType = "long", paramType = "path")
    @GetMapping(value = "queryOrgName")
    public ResponseResult<List<OrgNameSelect>> queryOrgName(@RequestParam(name = "userAuto") Long userAuto) {
        List<OrgNameSelect> list = vEmp2RoleService.selectOrgName(userAuto);
        if (list.size() == 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无资料，请输入其它查询条件!", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "回租报价：2、承办业代姓名下拉选")
    @ApiImplicitParam(name = "orgAuto", value = "部门序号", required = false, dataType = "long", paramType = "path")
    @GetMapping(value = "queryFName")
    public ResponseResult<List<FNameSelect>> queryFName(/*@RequestParam(name = "roleName")String roleName,*/
            @RequestParam(name = "orgAuto") Long orgAuto) {
        List<FNameSelect> list = vEmp2RoleService.selectFName("業務員", orgAuto);
        if (list.size() == 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无资料，请输入其它查询条件!", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "回租报价：1、总厂牌下拉选")
    @GetMapping(value = "queryFactoryBrandName")
    public ResponseResult<List<FactoryBrandNameSelect>> queryFactoryBrandName() {
        List<FactoryBrandNameSelect> list = factoryBrandService.selectFactoryBrandName();
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "回租报价：2、厂牌下拉选")
    @ApiImplicitParam(name = "factoryBrandAuto", value = "总厂牌序号", required = false, dataType = "long", paramType = "path")
    @GetMapping(value = "queryBrandName")
    public ResponseResult<List<BrandNameSelect>> queryBrandName(@RequestParam(name = "factoryBrandAuto") Long factoryBrandAuto) {
        List<BrandNameSelect> list = brandService.selectBrandName(factoryBrandAuto);
        if (list.size() == 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无资料，请输入其它查询条件!", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "回租报价：3、车型下拉选")
    @ApiImplicitParam(name = "brandAuto", value = "厂牌序号", required = false, dataType = "long", paramType = "path")
    @GetMapping(value = "queryClasenName")
    public ResponseResult<List<ClasenNameSelect>> queryClasenName(@RequestParam(name = "brandAuto") Long brandAuto) {
        List<ClasenNameSelect> list = brandService.selectClasenName(brandAuto);
        if (list.size() == 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无资料，请输入其它查询条件!", null);
        }
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
                                                                         @RequestParam(name = "pageIndex", defaultValue = "1") Integer pageIndex) {
        SupplierQueryParam supplierQueryParam = new SupplierQueryParam(3, searchWord, pageNum, pageSize, pageIndex);
        PageInfo<SupplierNamesDto> pageInfo = ordersService.selectSupplierNames(supplierQueryParam);
        if (pageInfo.getList().size() == 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无数据！", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", pageInfo);
    }

    @ApiOperation(value = "回租报价：客户全称列表分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesAuto", value = "业代序号", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "searchWord", value = "查询条件", required = false, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageIndex", value = "当前要求的页码索引", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryFNamesDto")
    public ResponseResult<PageInfo<FNamesDto>> querySupplierNamesFNamesDto(@RequestParam(name = "salesAuto", required = false) Long salesAuto,
                                                                           @RequestParam(name = "searchWord", required = false) String searchWord,
                                                                           @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                                                           @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                           @RequestParam(name = "pageIndex", defaultValue = "1") Integer pageIndex) {
        if (searchWord == null || searchWord == "") {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "请输入查询条件！", null);
        }
        FNamesQueryParam fNamesQueryParam = new FNamesQueryParam(salesAuto, searchWord, pageNum, pageSize, pageIndex);
        PageInfo<FNamesDto> pageInfo = ordersService.selectFNamesDto(fNamesQueryParam);
        if (pageInfo.getList().size() == 0) {
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
    public ResponseResult<List<LeasebackList>> queryLeasebackList(@RequestParam(name = "userAuto", required = false) Long userAuto,
                                                                  @RequestParam(name = "mode") Integer mode,
                                                                  @RequestParam(name = "searchWord", required = false) String searchWord,
                                                                  @RequestParam(name = "startDT", required = false) String startDT,
                                                                  @RequestParam(name = "endDT", required = false) String endDT) {
        LeasebackQueryParam leasebackQueryParam = new LeasebackQueryParam(userAuto, mode, searchWord, startDT, endDT);
        List<LeasebackList> lists = ordersService.selectLeasebackList(leasebackQueryParam);
        if (lists.size() == 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查无资料，请输入其它查询条件!", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    //贷款金额与贷款成数的计算公式
    public static double calculatePMT(double rate, double nper, double pv) {
        double v = (1 + (rate / 100 / 12));
        double t = (-(nper / 12) * 12);
        double result = (pv * (rate / 100 / 12)) / (1 - Math.pow(v, t));
        return result;
    }

    @ApiOperation(value = "回租报价：单号获取数据")
    @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    @GetMapping(value = "queryLeasebacks")
    public ResponseResult<Leasebacks> queryLeasebacks(@RequestParam(name = "ordersAuto", defaultValue = "0") Long ordersAuto) {
        Leasebacks leasebacks = ordersService.selectLeasebacks(ordersAuto);
        if (leasebacks == null) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查询条件无资料", null);
        }

        if (leasebacks.getTaxMode() == 5) {
            leasebacks.setTaxMode(6);
        }
        //退税年化利率计算
        double rentRateY = (calculatePMT(leasebacks.getRentRate().doubleValue(), leasebacks.getMm(), 1) * leasebacks.getMm() - 1) * 100 * 12 / leasebacks.getMm();
        //四舍五入保留两位小数
        BigDecimal bg = new BigDecimal(rentRateY);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        leasebacks.setRentRateY(f1 + "%");
        //GPS安装
        if (leasebacks.getGpsAmt().compareTo(BigDecimal.valueOf(0)) == 1) {
            leasebacks.setGps(1);
        } else {
            leasebacks.setGps(0);
        }
        //贷款金额与贷款成数的计算公式
        double dFee = (leasebacks.getInsureRealAmt().add(leasebacks.getAccessary().add(leasebacks.getFeeAmt()
                .add(leasebacks.getCarTax().add(leasebacks.getFinanceFee().add(leasebacks.getUrgentFee()
                        .add(leasebacks.getOutFee().add(leasebacks.getCarExtensionAmt())))))))).doubleValue();
        double p = ((leasebacks.getRentAmt().subtract(leasebacks.getStampTax())).doubleValue()) * 1.0 /
                ((leasebacks.getListPrice().subtract(leasebacks.getDisPrice())).doubleValue() + dFee);
        Integer amtP = Math.round(leasebacks.getRentAmt().subtract(leasebacks.getStampTax()).intValue());
        leasebacks.setAmtPNum(Math.round(p * 100));
        leasebacks.setAmtP(amtP + "(" + Math.round(p * 100) + "%)");
        //客户全称
//        leasebacks.setFName(leasebacks.getFName()+ " "+ leasebacks.getTradeItemAuto()+ " " + leasebacks.getCustomerStatus());

        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", leasebacks);
    }

    @ApiOperation(value = "回租报价：阶梯式租金")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryStepwiseList")
    public ResponseResult<List<StepwiseList>> queryStepwiseList(@RequestParam(name = "ordersAuto", required = false) Long ordersAuto) {
        if (ordersAuto == null) {
            throw new BusinessException(BusinessStatus.PARAM_ERROR);
        }
        List<StepwiseList> lists = ordersStepwiseService.selectByOrdersAuto(ordersAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = " 回租报价：签核明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ordersAuto", value = "试算单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "querySignOffList")
    public ResponseResult<List<SignOffList>> querySignOffList(@RequestParam(name = "ordersAuto", required = false) Long ordersAuto) {
        if (ordersAuto == null) {
            throw new BusinessException(BusinessStatus.PARAM_ERROR);
        }
        List<SignOffList> lists = ordersFDetailService.selectSignOffList(ordersAuto);
        for (SignOffList signOffList : lists) {
            switch (signOffList.getOrdersStatus()) {
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
            if (signOffList.getIsAgent() == 1) {
                signOffList.setCreditPerson(signOffList.getCreditPerson() + "(代理)");
            }
            if (signOffList.getCdt() == null) {
                signOffList.setCdtTime("");
            }
            if (signOffList.getCdt() != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(signOffList.getCdt());
                signOffList.setCdtTime(dateString);
            }
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "分摊表下载数据")
    @PostMapping(value = "getShareBtn")
    public ResponseResult<List<ShareBtn>> getShareBtn(@ApiParam(value = "回租报价：分摊表数据") @Valid @RequestBody ShareBtnParamDto shareBtnParamDto) {
        List<ShareBtn> list = Lists.newArrayList();
        BigDecimal dAmtSum = shareBtnParamDto.getRentAmt().subtract(shareBtnParamDto.getStampTax());
        BigDecimal dRentRate = shareBtnParamDto.getRateRate();
        Double dIncome = Double.valueOf(0);
        for (Integer i = 1; i <= shareBtnParamDto.getMm(); i++) {
            ShareBtn shareBtn = new ShareBtn();
            //本金
            shareBtn.setCapital(dAmtSum.doubleValue());
            //月租金
            shareBtn.setMonthRent(shareBtnParamDto.getRentMAmt().doubleValue());
            if (i == shareBtnParamDto.getMm()) {
                //摊还利息//四舍五入保留两位小数
                Double amortization = shareBtnParamDto.getRentMAmt().doubleValue() * shareBtnParamDto.getMm()
                        - (shareBtnParamDto.getRentAmt().doubleValue() - shareBtnParamDto.getStampTax().doubleValue())
                        - dIncome;
                shareBtn.setAmortization(BigDecimal.valueOf(amortization).setScale(2, BigDecimal.ROUND_HALF_UP));
                //利息税额
                BigDecimal t = BigDecimal.valueOf(amortization).setScale(2, BigDecimal.ROUND_HALF_UP);
                Double tax = t.doubleValue() / 1.06 * 0.06;
                shareBtn.setTax(BigDecimal.valueOf(tax).setScale(2, BigDecimal.ROUND_HALF_UP));
                //摊还本金
                shareBtn.setAmortizeAmt(dAmtSum);
                //本金余额
                shareBtn.setBalance(BigDecimal.valueOf(0));
            } else {
                Double dIncome1 = dAmtSum.doubleValue() * dRentRate.doubleValue() / 100 / 12;
                BigDecimal b = new BigDecimal(dIncome1);
                double dIncome2 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                //摊还利息//四舍五入保留两位小数
                shareBtn.setAmortization(BigDecimal.valueOf(dIncome2));//因为计算公式相同，所以用这个值
                //利息税额
                Double tax2 = dIncome2 / 1.06 * 0.06;
                shareBtn.setTax(BigDecimal.valueOf(tax2).setScale(2, BigDecimal.ROUND_HALF_UP));
                //摊还本金
                shareBtn.setAmortizeAmt(shareBtnParamDto.getRentMAmt().subtract(BigDecimal.valueOf(dIncome2)));
                //本金余额
                dAmtSum = dAmtSum.setScale(2, BigDecimal.ROUND_HALF_UP).add(BigDecimal.valueOf(dIncome2)).subtract(shareBtnParamDto.getRentMAmt());
                shareBtn.setBalance(dAmtSum);
            }
            list.add(shareBtn);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "分摊表下载数据", list);
    }


    /**
     * 保险金额、保险明细先注释
     */
    /*@ApiOperation(value = "回租报价：保险金额")
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
    }*/

    /**
     * 回租报价未完成：复制试算报价单按钮先注释
     */
    /*@ApiOperation(value = "回租报价未完成：复制试算报价单按钮(此接口如要测试请联系后端)")
    @PostMapping(value = "copyOrders")
    public ResponseResult<Long> copyOrders(@ApiParam(value = "回租报价：复制试算报价单按钮数据") @Valid @RequestBody CopyOrdersParamDto copyOrdersParamDto){
        if (copyOrdersParamDto.getOrdersAuto() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "复制前请先暂存!", null);
        }
        Orders orders = new Orders();
        if (copyOrdersParamDto.getPostType() != 4){
            orders.setCarBaseAuto(0L);
            orders.setMakNo("");
        }
        orders.setPostType(0);
        orders.setOrdersOld(copyOrdersParamDto.getOrdersAuto());
        copyOrdersParamDto.setStatus("0");
        if (copyOrdersParamDto.getCompanyInc() != 1){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "请选择公司别为格上租赁!", null);
        }
        if (copyOrdersParamDto.getBsType() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "请选择排档方式!", null);
        }
        if (copyOrdersParamDto.getClasenCode() == ""){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "请填写【车型代码】!", null);
        }
        if (copyOrdersParamDto.getCarColor() == ""){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "请填写【车色】!", null);
        }
        if (copyOrdersParamDto.getMortgageAddr() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "请选择抵押地!", null);
        }
        if (copyOrdersParamDto.getCarSource() == 4){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "不能承做外购二手车，请确认!", null);
        }
        //todo:判断上牌规费公司别是否一致,可能需要前端判断
        if (copyOrdersParamDto.getOil() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "请选择该车燃油种类！", null);
        }
        if (copyOrdersParamDto.getCustSource() == 70){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "客户来源选取错误，请重新选取！", null);
        }
        if (copyOrdersParamDto.getPushMoney().compareTo(BigDecimal.valueOf(0)) == 1){
            if (copyOrdersParamDto.getCustSource() != 230 && copyOrdersParamDto.getCustSource() != 240){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "客户来源选取错误，请重新选取！", null);
            }
        }
        if (copyOrdersParamDto.getCustSource() == 10){
            //todo:s_OrderCHK
            copyOrdersParamDto.setCustSource(120L);
        }
        switch (copyOrdersParamDto.getPostType().intValue()){
            case 1:
                if (){//todo:s_Credit_Order_CHK

                }else{
                    return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "变更件原试算单号必须有授信!", null);
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                break;
            default:
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "案件别错误，请重新选取！", null);
        }
        if (copyOrdersParamDto.getSalesTax().compareTo(BigDecimal.valueOf(0)) == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "税别错误！", null);
        }
        if (copyOrdersParamDto.getInsurePercent() == 1 && copyOrdersParamDto.getPercnt() > 5){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "座位超过5人需选择保险6-10人座！", null);
        }
        if (copyOrdersParamDto.getPushMoney().compareTo(BigDecimal.valueOf(0)) == 1){
            if (copyOrdersParamDto.getPushMan().length() == 0){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "请填写介绍人！", null);
            }
            if (copyOrdersParamDto.getPushTel().length() != 11){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "介绍人行动电话需为11码！", null);
            }
        }
        //todo:判断上牌规费公司别是否一致,可能需要前端判断
        if (copyOrdersParamDto.getPushMoney().compareTo(BigDecimal.valueOf(0)) == 1){
            if (copyOrdersParamDto.getRateRate().compareTo(BigDecimal.valueOf(10.7)) == -1 ){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "年利率(含税)小于10.7%，无法申请佣金！", null);
            }else if (copyOrdersParamDto.getMm() < 24
                    && ((copyOrdersParamDto.getRateRate().compareTo(BigDecimal.valueOf(10.7)) == 1 || copyOrdersParamDto.getRateRate().compareTo(BigDecimal.valueOf(10.7)) == 0)
                    && copyOrdersParamDto.getRateRate().compareTo(BigDecimal.valueOf(13)) == -1)){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "24期以下，无法申请佣金！", null);
            }else if (copyOrdersParamDto.getMm() < 12){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "12期以下，无法申请佣金！", null);
            }
        }
        //todo:btnCount_Click
        //todo:DoSave
        //todo:新报价单也更新附件地址.
        //todo:新增成功后返回ordersAuto
        return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "保存失败", null);
    }
    */
}
