package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.*;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.RptVstFlowService;
import com.funtl.myshop.plus.provider.api.RptVstService;
import com.funtl.myshop.plus.provider.api.VEmpService;
import com.funtl.myshop.plus.provider.api.VisitPlanService;
import com.funtl.myshop.plus.provider.domain.*;
import com.funtl.myshop.plus.provider.dto.ClientCheckDto;
import com.funtl.myshop.plus.provider.dto.CrmArrangeDto;
import com.funtl.myshop.plus.provider.dto.CrmArrangeQueryParam;
import com.funtl.myshop.plus.provider.dto.TripQueryParam;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags = "客户模块相关操作")
@RestController
@RequestMapping(value = "client")
public class ClientController {
    @Reference(version = "1.0.0")
    private RptVstFlowService rptVstFlowService;

    @Reference(version = "1.0.0")
    private RptVstService rptVstService;

    @Reference(version = "1.0.0")
    private VisitPlanService visitPlanService;

    @Reference(version = "1.0.0")
    private VEmpService vEmpService;

    /**
     * 目前没用到的api
     *
     */
    /*@ApiOperation(value = "根据行程单号获取审核信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rptVstAuto", value = "行程单号", required = false, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryTripDetailList")
    public ResponseResult<List<TripDetailList>> queryTripDetailList(@RequestParam(name = "rptVstAuto", required = false)Long rptVstAuto ){
        List<TripDetailList> lists = rptVstFlowService.selectByRptVstAuto(rptVstAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "获取行程报告记录-主档信息待签核")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "status", value = "状态 0 未审核 1 已审核", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "userAuto", value = "操作人序号", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "roleAuto", value = "权限序号", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "orgAuto", value = "部门序号", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryTripRecorderOne")
    public ResponseResult<List<TripRecorderList>> queryTripRecorderOne(@RequestParam(name = "year", required = false)Integer year,
                                                                        @RequestParam(name = "month", required = false)Integer month,
                                                                        @RequestParam(name = "status", required = false)Integer status,
                                                                        @RequestParam(name = "userAuto", required = false)Integer userAuto,
                                                                        @RequestParam(name = "roleAuto", required = false)Integer roleAuto,
                                                                        @RequestParam(name = "orgAuto", required = false)Integer orgAuto){
        TripQueryParam tripQueryParam = new TripQueryParam(year,month,status,userAuto,roleAuto,orgAuto);
        List<TripRecorderList> lists = rptVstService.selectByTrip(tripQueryParam);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "获取行程报告记录-可跨签信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "month", value = "月份", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "status", value = "状态 0 未审核 1 已审核", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "userAuto", value = "操作人序号", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "roleAuto", value = "权限序号", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "orgAuto", value = "部门序号", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryTripRecorderTwo")
    public ResponseResult<List<TripRecorderList>> queryTripRecorderTwo(@RequestParam(name = "year", required = false)Integer year,
                                                                        @RequestParam(name = "month", required = false)Integer month,
                                                                        @RequestParam(name = "status", required = false)Integer status,
                                                                        @RequestParam(name = "userAuto", required = false)Integer userAuto,
                                                                        @RequestParam(name = "roleAuto", required = false)Integer roleAuto,
                                                                        @RequestParam(name = "orgAuto", required = false)Integer orgAuto){
        TripQueryParam tripQueryParam = new TripQueryParam(year,month,status,userAuto,roleAuto,orgAuto);
        List<TripRecorderList> lists = rptVstService.selectByTripTwo(tripQueryParam);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "行程报告审核(此接口如要测试请联系后端)")
    @PutMapping(value = "update")
    public ResponseResult<String> update(@ApiParam(value = "行程报告审核数据") @Valid @RequestBody ClientCheckParamDto clientCheckParamDto){
        if (clientCheckParamDto.getMemo() == null || clientCheckParamDto.getMemo().isEmpty()){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "请输入审核意见！", null);
        }
        ClientCheckDto clientCheckDto = new ClientCheckDto();
        BeanUtils.copyProperties(clientCheckParamDto,clientCheckDto);
        Integer i = rptVstFlowService.update(clientCheckDto);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "审核失败", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "审核完成", null);
    }
    */

    @ApiOperation(value = "CRM:获取行程报告列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAuto", value = "用户序号", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "customerName", value = "客户名称", required = false, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryCrmTripList")
    public ResponseResult<List<CrmTripList>> queryCrmTripList(@RequestParam(name = "userAuto")Integer userAuto,
                                                              @RequestParam(name = "customerName", required = false)String customerName){
        List<CrmTripList> lists = rptVstService.selectCrmTripList(userAuto,customerName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "CRM:获取行程报告具体数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rptVstAuto", value = "报告序号", required = true, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "contName", value = "联系人姓名", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryCrmDetail")
    public ResponseResult<CrmDetail> queryCrmDetail(@RequestParam(name = "rptVstAuto")Long rptVstAuto,
                                                    @RequestParam(name = "contName")String contName){
        CrmDetail crmDetail = rptVstService.selectByRptVstAuto(rptVstAuto,contName);
        if (crmDetail == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "查询条件无数据或已审核", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", crmDetail);
    }

    @ApiOperation(value = "CRM:客户名称下拉选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fName", value = "客户名称", required = false, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "salesAuto", value = "业代序号", required = true, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryByFName")
    public ResponseResult<List<CustomerNameSelect>> queryByFName(@RequestParam(name = "fName", required = false)String fName,
                                                                 @RequestParam(name = "salesAuto")Long salesAuto){
        List<CustomerNameSelect> list = rptVstService.selectByFName(fName,salesAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "CRM:联系人下拉选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tradeItemAuto", value = "客户序号", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "contName", value = "联系人姓名", required = false, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryByTradeItemAuto")
    public ResponseResult<List<ContNameSelect>> queryByTradeItemAuto(@RequestParam(name = "tradeItemAuto", required = false)Long tradeItemAuto,
                                                                     @RequestParam(name = "contName", required = false)String contName){
        List<ContNameSelect> list = rptVstService.selectByTradeItemAuto(tradeItemAuto,contName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "CRM:客户来源、活动内容、进度下拉选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "types", value = "类型: 1 客户来源 2 活动内容 3 进度", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "num", value = "客户来源、活动内容、进度对应的num", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryItemNameAndNum")
    public ResponseResult<List<CrmItemNameSelect>> queryItemNameAndNum(@RequestParam(name = "types")Integer types,
                                                                       @RequestParam(name = "num", defaultValue = "0")Integer num){
        List<CrmItemNameSelect> CrmItemNameSelects = rptVstService.selectByTypes(types,num);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", CrmItemNameSelects);
    }

    @ApiOperation(value = "CRM:省、市、区下拉选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型: 1省 2市 3区", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "code", value = "省、市、区编码", required = true, dataType = "long", paramType = "path")
    })
    @GetMapping(value = "queryAddressList")
    public ResponseResult<List<AddressList>> queryAddressList(@RequestParam(name = "type")Integer type,
                                                              @RequestParam(name = "code",required = false)Long code){
        List<AddressList> lists = visitPlanService.selectByType(type,code);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "CRM:业代下拉选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "salesAuto", value = "业代序号", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "saleName", value = "业代名称", required = false, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "querySaleNameSelect")
    public ResponseResult<List<SaleNameSelect>> querySaleNameSelect(@RequestParam(name = "salesAuto", required = false)Long salesAuto,
                                                                    @RequestParam(name = "saleName", required = false)String saleName){
        List<SaleNameSelect> lists = vEmpService.selectSaleName(salesAuto,saleName);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", lists);
    }

    @ApiOperation(value = "CRM:获取行程安排数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "visitId", value = "拜访id", required = false, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "kind", value = "查询类别：1客户名称 2联系人姓名", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "searchWord", value = "查询条件", required = false, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "salesName", value = "业代序号", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = false, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageIndex", value = "当前要求的页码索引", required = false, dataType = "int", paramType = "path")
    })
    @GetMapping(value = "queryCrmArrangeDto")
    public ResponseResult<PageInfo<CrmArrangeDto>> queryCrmArrangeDto(@RequestParam(name = "visitId", defaultValue = "0") Long visitId,
                                                                      @RequestParam(name = "kind", required = false) Integer kind,
                                                                      @RequestParam(name = "searchWord", required = false) String searchWord,
                                                                      @RequestParam(name = "salesName") String salesName,
                                                                      @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
                                                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                      @RequestParam(name = "pageIndex", defaultValue = "1") Integer pageIndex){
        CrmArrangeQueryParam crmArrangeQueryParam = new CrmArrangeQueryParam(visitId,kind,searchWord,salesName,pageNum,pageSize,pageIndex);
        PageInfo<CrmArrangeDto> pageInfo = visitPlanService.selectCrmArrangeDto(crmArrangeQueryParam);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", pageInfo);
    }

    @ApiOperation(value = "CRM:新增行程安排数据中visitAuto的值")
    @GetMapping(value = "queryMaxVisitAuto")
    public ResponseResult<Integer> queryMaxVisitAuto(){
        VisitPlan visitPlan = visitPlanService.selectMaxVisitAuto();
        Integer visitAuto = visitPlan.getVisitAuto() + 1;
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", visitAuto);
    }

    @ApiOperation(value = "CRM:新增行程安排数据(此接口如要测试请联系后端)")
    @PostMapping(value = "insertCrmArrange")
    public ResponseResult<Long> insertCrmArrange(@ApiParam(value = "CRM:新增行程安排数据") @Valid @RequestBody CrmArrangeInsertParamDto crmArrangeParamDto) throws ParseException {
        VisitPlan visitPlan = new VisitPlan();
        BeanUtils.copyProperties(crmArrangeParamDto,visitPlan);
        visitPlan.setAddrStreet(crmArrangeParamDto.getAddrArea());
        visitPlan.setCuser(crmArrangeParamDto.getSalesAuto());
        //联系人t1.Contact_Auto=t4.ContectType
        visitPlan.setContactAuto(crmArrangeParamDto.getContectType().toString());
        visitPlan.setCdt(new Date());
        visitPlan.setIsVsted(false);
        visitPlan.setStatus(0);
        //拜访时间：拜访日期加具体时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = df.parse(crmArrangeParamDto.getVstDate() + " " + crmArrangeParamDto.getVstTime());
        visitPlan.setVstDate(date);
        Long i = visitPlanService.insert(visitPlan);
        if (i != 0){
//            Long visitId = visitPlan.getVisitId();
            return new ResponseResult<>(ResponseResult.CodeStatus.OK, "新插入数据的visitId", i);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "保存失败", null);
    }

    @ApiOperation(value = "CRM:编辑行程安排数据(此接口如要测试请联系后端)")
    @PutMapping(value = "updateCrmArrange")
    public ResponseResult<String> updateCrmArrange(@ApiParam(value = "CRM:编辑行程安排数据") @Valid @RequestBody CrmArrangeParamDto crmArrangeParamDto) throws ParseException {
        if (crmArrangeParamDto.getVisitId() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        //根据拜访id获取拜访信息
        VisitPlan visitPlan = visitPlanService.selectByVisitIdAndAuto(crmArrangeParamDto.getVisitId(),crmArrangeParamDto.getVisitAuto());
        if (visitPlan == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "此拜访信息不存在", null);
        }
        if (visitPlan.getIsVsted() == true){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "已拜访信息不可编辑", null);
        }
        BeanUtils.copyProperties(crmArrangeParamDto,visitPlan);
        visitPlan.setAddrStreet(crmArrangeParamDto.getAddrArea());
        visitPlan.setMuser(crmArrangeParamDto.getSalesAuto().longValue());
        visitPlan.setMdt(new Date());
        //拜访时间：拜访日期加具体时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = df.parse(crmArrangeParamDto.getVstDate() + " " + crmArrangeParamDto.getVstTime());
        visitPlan.setVstDate(date);
        //联系人t1.Contact_Auto=t4.ContectType
        visitPlan.setContactAuto(crmArrangeParamDto.getContectType().toString());
        Integer i = visitPlanService.update(visitPlan);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "修改失败", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "修改成功", null);
    }

    @ApiOperation(value = "CRM:行程安排删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "visitId", value = "拜访id", required = true, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "salesAuto", value = "业代序号", required = true, dataType = "long", paramType = "path")
    })
    @DeleteMapping(value = "delete")
    public ResponseResult<VisitPlan> delete(@RequestParam(name = "visitId")Long visitId,
                                            @RequestParam(name = "salesAuto")Long salesAuto){
        VisitPlan visitPlan = visitPlanService.selectByVisitId(visitId);
        if (visitPlan == null) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "此拜访信息不存在", null);
        }
        if (visitPlan.getIsVsted() == true){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "已拜访信息不可删除", null);
        }
        //删除状态为-1
        visitPlan.setStatus(-1);
        visitPlan.setMuser(salesAuto);
        visitPlan.setMdt(new Date());
        Integer i = visitPlanService.update(visitPlan);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "删除失败", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "删除成功", null);
    }

    @ApiOperation(value = "CRM:行程记录打卡(此接口如要测试请联系后端)")
    @PostMapping(value = "insertCrmDetail")
    public ResponseResult<Long> insertCrmDetail(@ApiParam(value = "CRM:行程记录打卡数据") @Valid @RequestBody CrmDetailInsertParamDto crmDetailInsertParamDto){

        VisitPlan visitPlan = visitPlanService.selectByVisitId(crmDetailInsertParamDto.getVisitId());
        if (visitPlan == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "拜访id不存在", null);
        }
        RptVst rptVst = new RptVst();
        BeanUtils.copyProperties(crmDetailInsertParamDto,rptVst);
        rptVst.setCUser(crmDetailInsertParamDto.getSalesAuto());
        rptVst.setCdt(new Date());
        Long i = rptVstService.insert(rptVst);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "行程记录保存失败", null);
        }
        //行程记录提交成功，行程安排显示已拜访
        visitPlan.setIsVsted(true);
        visitPlan.setMuser(crmDetailInsertParamDto.getSalesAuto().longValue());
        visitPlan.setMdt(new Date());
        Integer i2 = visitPlanService.update(visitPlan);
        if (i2 == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "是否拜访修改失败", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "新插入数据的rptVstAuto", i);
    }

    @ApiOperation(value = "CRM:行程报告提交(此接口如要测试请联系后端)")
    @PutMapping(value = "updateCrmDetail")
    public ResponseResult<String> updateCrmDetail(@ApiParam(value = "CRM:行程报告提交数据") @Valid @RequestBody CrmDetailParamDto crmDetailParamDto){
        if (crmDetailParamDto.getRptVstAuto() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "参数异常", null);
        }
        RptVst rptVst = new RptVst();
        BeanUtils.copyProperties(crmDetailParamDto,rptVst);
        rptVst.setMUser(crmDetailParamDto.getSalesAuto());
        rptVst.setMcDT(new Date());
        Integer i = rptVstService.update(rptVst);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "保存失败", null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "保存成功", null);
    }

}
