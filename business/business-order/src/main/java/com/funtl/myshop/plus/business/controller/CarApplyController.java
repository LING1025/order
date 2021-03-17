package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.*;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.commons.utils.MapperUtils;
import com.funtl.myshop.plus.controller.LocationUtils;
import com.funtl.myshop.plus.provider.api.*;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.*;
import com.google.common.collect.Lists;
import io.swagger.annotations.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Api(tags = "车队管理模块相关操作")
@RestController
@RequestMapping(value = "carApply")
public class CarApplyController {

    @Reference(version = "1.0.0")
    private PurchaseRequestService purchaseRequestService;

    @Reference(version = "1.0.0")
    private PurchaseService purchaseService;

    @Reference(version = "1.0.0")
    private PurchaseRRFlowService purchaseRRFlowService;






    @ApiOperation(value = "用车审核：选择代理人")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "代理人id", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryAgentList")
    public ResponseResult<List<AgentList>> queryAgentList(@RequestParam(name = "userAuto",required = false) Long userAuto){
        //代理人id查询
        List<AgentList> lists = creditAgentService.selectAgentList(userAuto);
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
    @ApiImplicitParam(name = "carApplicationAuto",value = "用车申请单号",required = true,dataType = "long",paramType = "path")
    @GetMapping(value = "queryCheckOne")
    public ResponseResult<CheckOne> queryCheckOne(@RequestParam(name = "carApplicationAuto") Long carApplicationAuto){
        CheckOne checkOne = carApplicationService.selectCheckOne(carApplicationAuto);
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

    @ApiOperation(value = "用车申请：撤销(此接口如要测试请联系后端)")
    @PutMapping(value = "deleteApply")
    public ResponseResult<String> DeleteApply(@ApiParam(value = "用车申请：撤销") @Valid @RequestBody RepealApplyParamDto repealApplyParamDto){
        CarApplication carApplication = carApplicationService.selectByCarApplicationAuto(repealApplyParamDto.getCarApplicationAuto());
        if (carApplication.getStatus() < 10){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"未送件无需撤销",null);
        }
        if (carApplication.getStatus() >= 30){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"车辆已使用不可撤销",null);
        }
        RepealApplyDto repealApplyDto = new RepealApplyDto();
        BeanUtils.copyProperties(repealApplyParamDto,repealApplyDto);
        Integer i = carApplicationService.deleteByCarApplicationAuto(repealApplyDto);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"撤销失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"撤销成功",null);
    }

    @ApiOperation(value = "车辆归还：归还钥匙(此接口如要测试请联系后端)")
    @PutMapping(value = "giveBackKey")
    public ResponseResult<String> GiveBackKey(@ApiParam(value = "车辆归还：归还钥匙数据") @Valid @RequestBody GiveBackKeyParamDto giveBackKeyParamDto){
        GiveBackKeyDto giveBackKeyDto = new GiveBackKeyDto();
        BeanUtils.copyProperties(giveBackKeyParamDto,giveBackKeyDto);
        Integer i = carApplicationService.giveBack(giveBackKeyDto);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"归还失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"归还成功",null);
    }

    @ApiOperation(value = "车辆归还：提交实时拍照数据(此接口如要测试请联系后端)")
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
        Integer i = carApplicationService.takePhoto(carApplication);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提交失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"提交成功",null);
    }

    @ApiOperation(value = "车辆归还：判断是否逾期")
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
    }

    @ApiOperation(value = "车辆归还：用车费用请款(此接口如要测试请联系后端)")
    @PostMapping(value = "insertUseCarFee")
    public ResponseResult<String> insertUseCarFee(@ApiParam(value = "车辆归还：用车费用请款数据") @Valid @RequestBody UserCarRequestParamDto userCarRequestParamDto){
        CarApplication carApplication = carApplicationService.selectByCarApplicationAuto(userCarRequestParamDto.getCarApplicationAuto());
        if (carApplication == null) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "此用车申请信息不存在", null);
        }
        if (userCarRequestParamDto.getRequestUser() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"请款人序号必填",null);
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
        purchaseRequest.setIncAuto(requestInc.getIncAuto());//公司别
        purchaseRequest.setRequestType(1);//请款类别:1一般事务
        purchaseRequest.setRequestDT(new Date());//请款日期
        purchaseRequest.setPayRequestAmt(userCarRequestParamDto.getRequestAmt());//实际请款金额(请款总金额-暂借款金额)
        purchaseRequest.setIsZJ(0);//是否暂借(0:不1:是)
        purchaseRequest.setZJAmt(BigDecimal.valueOf(0));//暂借金额
        purchaseRequest.setZjPayType(0);//暂借付款别
        purchaseRequest.setStatus(10);//状态10审核中
        purchaseRequest.setIsRR(1);//与请款关联(0:否;1:是)
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
    @ApiOperation(value = "车辆归还：用车累计费用金额(此接口如要测试请联系后端)")
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

    @ApiOperation(value = "车辆归还：费用列表")
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

    @ApiOperation(value = "车辆归还：删除费用列表中具体数据")
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
