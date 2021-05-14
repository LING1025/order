package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.CarPhotoParamDto;
import com.funtl.myshop.plus.business.dto.RequestAmtParamDto;
import com.funtl.myshop.plus.business.dto.UserCarRequestParamDto;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.LKRQueryParam;
import com.funtl.myshop.plus.provider.dto.OpenQueryParam;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Api(tags = "用车费用管理相关操作")
@RestController
@RequestMapping(value = "carBack")
public class CarBackController {
    @Reference(version = "1.0.0")
    private CarApplicationService carApplicationService;

    @Reference(version = "1.0.0")
    private PurchaseRequestService purchaseRequestService;

    @Reference(version = "1.0.0")
    private PurchaseService purchaseService;

    @Reference(version = "1.0.0")
    private PurchaseRRFlowService purchaseRRFlowService;


    @ApiOperation(value = "车辆照片：提交实时拍照数据(此接口如要测试请联系后端)")
    @PutMapping(value = "updatePhoto")
    public ResponseResult<String> updatePhoto(@ApiParam(value = "车辆归还：实时拍照数据") @Valid @RequestBody CarPhotoParamDto carPhotoParamDto){
        if (carPhotoParamDto.getLoginUserID() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"登录人userAuto未赋值",null);
        }
        if (carPhotoParamDto.getCarApplicationAuto() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"用车申请单号未赋值",null);
        }
        CarApplication carApplication = new CarApplication();
        BeanUtils.copyProperties(carPhotoParamDto,carApplication);
        carApplication.setMUser(carPhotoParamDto.getLoginUserID().intValue());
        carApplication.setTime1(new Date());
        carApplication.setTime2(new Date());
        carApplication.setTime3(new Date());
        carApplication.setTime4(new Date());
        carApplication.setTime5(new Date());
        Integer i = carApplicationService.takePhoto(carApplication);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提交失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"提交成功",null);
    }

    @ApiOperation(value = "银行别下拉选数据")
    @ApiImplicitParam(name = "bankNameT",value = "银行名称",required = false,dataType = "String",paramType = "path")
    @GetMapping(value = "queryBank")
    public ResponseResult<List<BankList>> queryBank(@RequestParam(name = "bankNameT") String bankNameT){
        List<BankList> lists = purchaseRequestService.selectBank(bankNameT);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "领款人或供应商搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "查询类别：1领款人或供应商名称搜索 2选取时获取",required = true,dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "name",value = "领款人或供应商",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "totalAuto",value = "序号",required = false,dataType = "Long",paramType = "path")
    })
    @GetMapping(value = "queryLKR")
    public ResponseResult<List<LKRList>> queryLKR(@RequestParam(name = "type") Integer type,
                                                  @RequestParam(name = "name") String name,
                                                  @RequestParam(name = "totalAuto") Long totalAuto){
        LKRQueryParam lkrQueryParam = new LKRQueryParam(type,name,totalAuto);
        List<LKRList> lists = purchaseRequestService.selectLKR(lkrQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"查无资料",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "开户行搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "查询类别：1开户行搜索 2选取时获取",required = true,dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "bankName",value = "开户行名称",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "bankDetailAuto",value = "开户行序号",required = false,dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageIndex", value = "当前要求的页码索引", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryOpen")
    public ResponseResult<List<OpenList>> queryOpen(@RequestParam(name = "type") Integer type,
                                                           @RequestParam(name = "bankName") String bankName,
                                                           @RequestParam(name = "bankDetailAuto") Long bankDetailAuto,
                                                           @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
                                                           @RequestParam(name = "pageIndex", defaultValue = "1") Integer pageIndex){
        OpenQueryParam openQueryParam = new OpenQueryParam(type,bankName,bankDetailAuto,pageSize,pageIndex);
        List<OpenList> lists = purchaseRequestService.selectOpen(openQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"查无资料，请输入正确的查询条件!",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }


    /*@ApiOperation(value = "车辆归还：判断是否逾期")
    @ApiImplicitParam(name = "carApplicationAuto",value = "用车申请单号",required = true,dataType = "Long",paramType = "path")
    @GetMapping(value = "queryIsOver")
    public ResponseResult<Integer> queryIsOver(@RequestParam(name = "carApplicationAuto") Long carApplicationAuto) {
        CarApplication carApplication = carApplicationService.selectByCarApplicationAuto(carApplicationAuto);
        if (carApplication == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"此单号不存在",null);
        }
        if (carApplication.getPlanEndDT().before(new Date())){ //若当前时间大于结束时间则超时
            return new ResponseResult<>(ResponseResult.CodeStatus.OK,"已逾期",1);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"未逾期",0);
    }*/

    @ApiOperation(value = "用车费用：请款(此接口如要测试请联系后端)")
    @PostMapping(value = "insertUseCarFee")
    public ResponseResult<String> insertUseCarFee(@ApiParam(value = "车辆归还：用车费用请款数据") @Valid @RequestBody UserCarRequestParamDto userCarRequestParamDto){
        CarApplication carApplication = carApplicationService.selectByCarApplicationAuto(userCarRequestParamDto.getCarApplicationAuto());
        if (carApplication == null) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "此用车申请信息不存在", null);
        }
        if (userCarRequestParamDto.getRequestUser() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请款人序号必填",null);
        }
        if(userCarRequestParamDto.getPayee() == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请输入供应商/领款人!",null);
        }

        userCarRequestParamDto.setCuser(userCarRequestParamDto.getRequestUser());
        userCarRequestParamDto.setCdt(new Date());

        RequestInc requestInc = purchaseRequestService.selectInc(userCarRequestParamDto.getRequestUser());
        if (requestInc == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"此请款人信息不存在",null);
        }

        //请款
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        BeanUtils.copyProperties(userCarRequestParamDto,purchaseRequest);
        if(userCarRequestParamDto.getPayType() != 4){
            purchaseRequest.setBankType(0);
            purchaseRequest.setLKIncAuto(requestInc.getIncAuto());//现金、支票等领款公司别
        }else{
            if(userCarRequestParamDto.getPayeeAccount() == null){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请输入账号!",null);
            }
            if(userCarRequestParamDto.getBankName() == null){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请输入开户行!",null);
            }
            if (userCarRequestParamDto.getPayType() == 0){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请选择银行别!",null);
            }
            purchaseRequest.setLKIncAuto(0L);
        }
        purchaseRequest.setIncAuto(requestInc.getIncAuto());//公司别
        purchaseRequest.setRequestType(1);//请款类别:1一般事务
        purchaseRequest.setRequestDT(new Date());//请款日期
        purchaseRequest.setPayRequestAmt(userCarRequestParamDto.getRequestAmt());//实际请款金额(请款总金额-暂借款金额)
        purchaseRequest.setIsZJ(0);//是否暂借(0:不1:是)
        purchaseRequest.setZJAmt(BigDecimal.valueOf(0));//暂借金额
        purchaseRequest.setZjPayType(0);//暂借付款别
        purchaseRequest.setStatus(10);//状态10审核中
        purchaseRequest.setIsRR(1);//与请款关联(0:否;1:是)
        purchaseRequest.setIsBatch(0);
        purchaseRequest.setIsEas(0);
        Long i = purchaseRequestService.insert(purchaseRequest);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"用车请款数据插入失败",null);
        }

        //物品明细
        Purchase purchase = new Purchase();
        BeanUtils.copyProperties(userCarRequestParamDto,purchase);
        purchase.setRrAuto(i);//请款单号
        purchase.setPurchaseName(userCarRequestParamDto.getFeeTypeName());//物品名称
        purchase.setPurchaseRequisitionAuto(0L);//请款物品对应的请购单号
        purchase.setType(1);//请购请款类别(0:请购1:请款)
        purchase.setPurchasePrice(userCarRequestParamDto.getRequestAmt());//单价
        purchase.setPurchaseAmount(1);//数量
        purchase.setPurchaseTotalAmt(userCarRequestParamDto.getRequestAmt());//单个物品总额
        purchase.setUseDep(requestInc.getUseDep());//使用部门
        Long i2 = purchaseService.insert(purchase);
        if (i2 == 0){
            purchaseRequestService.deleteById(i);
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"用车请款物品明细插入失败",null);
        }

        Integer i3 = purchaseRRFlowService.flowInsert(i,userCarRequestParamDto.getRequestUser());
        if (i3 == 1){ //存储过程第一个数字是0行影响
            purchaseRequestService.deleteById(i);
            purchaseService.deleteById(i2);
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请款单送签出错",null);
        }

        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"请款成功",null);
    }
    @ApiOperation(value = "用车费用：用车累计费用金额(此接口如要测试请联系后端)")
    @PutMapping(value = "updateRequestFee")
    public ResponseResult<String> updateRequestFee(@ApiParam(value = "车辆归还：用车费用请款数据") @Valid @RequestBody RequestAmtParamDto requestAmtParamDto) {
        CarApplication carApplication = carApplicationService.selectByCarApplicationAuto(requestAmtParamDto.getCarApplicationAuto());
        if (carApplication == null) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "此用车申请信息不存在", null);
        }
        if (requestAmtParamDto.getRequestUser() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请款人序号必填",null);
        }
        carApplication.setMUser(requestAmtParamDto.getRequestUser().intValue());
        carApplication.setMdt(new Date());
        carApplication.setUseCarAmt(requestAmtParamDto.getUseCarAmt());
        Integer i3 = carApplicationService.updateById(carApplication);
        if (i3 == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"保存失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"保存成功",null);
    }

    @ApiOperation(value = "用车费用：费用列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requestUser",value = "请款人序号",required = true,dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "carApplicationAuto",value = "用车申请单号",required = true,dataType = "Long",paramType = "path")
    })
    @GetMapping(value = "queryPurchaseFeeList")
    public ResponseResult<List<PurchaseFeeList>> queryPurchaseFeeList(@RequestParam(name = "requestUser",defaultValue = "0") Long requestUser,
                                                                      @RequestParam(name = "carApplicationAuto",defaultValue = "0") Long carApplicationAuto){
        if (requestUser == 0L || carApplicationAuto == 0L){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请输入请款人序号和用车申请单号",null);
        }
        List<PurchaseFeeList> lists = purchaseRequestService.selectPurchaseFeeList(requestUser,carApplicationAuto);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无请款数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "用车费用：删除费用列表中具体数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requestUser",value = "请款人序号",required = true,dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "purchaseRequestAuto",value = "请款单号",required = true,dataType = "Long",paramType = "path")
    })
    @PutMapping(value = "delete")
    public ResponseResult<PurchaseRequest> delete(@RequestParam(name = "requestUser",defaultValue = "0") Long requestUser,
                                                  @RequestParam(name = "purchaseRequestAuto",defaultValue = "0") Long purchaseRequestAuto){
        if (requestUser == 0L || purchaseRequestAuto == 0L){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请输入请款人序号和请款单号",null);
        }
        PurchaseRequest purchaseRequest = purchaseRequestService.selectById(purchaseRequestAuto);
        if (purchaseRequest == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请款单号不存在",null);
        }
        purchaseRequest.setStatus(-1);
        purchaseRequest.setMuser(requestUser);
        purchaseRequest.setMdt(new Date());
        Integer i = purchaseRequestService.update(purchaseRequest);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请款明细删除失败",null);
        }
        //费用列表删除信息时也要将送签删除，因为请款一键送签了
        Integer i2 = purchaseRRFlowService.deleteByRrAuto(purchaseRequestAuto);
        if (i2 == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"送签删除失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"删除成功",null);

    }
}
