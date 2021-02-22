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
    private ItemCodeService itemCodeService;

    @Reference(version = "1.0.0")
    private VEmpService vEmpService;

    @Reference(version = "1.0.0")
    private CarApplicationService carApplicationService;

    @Reference(version = "1.0.0")
    private OrgCarService orgCarService;

    @Reference(version = "1.0.0")
    private CreditAgentService creditAgentService;

    @Reference(version = "1.0.0")
    private AspnetUsersService aspnetUsersService;

    /*@ApiOperation(value = "经纬度转地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lng", value = "经度", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "lat", value = "纬度", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryLocation")
    public ResponseResult<GetLocation> queryLocation(@RequestParam(name = "lng")String lng,
                                                        @RequestParam(name = "lat")String lat) throws Exception {
        Map<String, Object> map = LocationUtils.getLocation(lng, lat);
        GetLocation getLocation = new GetLocation();
        getLocation.setAddress((String) map.get("address"));
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", getLocation);
    }*/

    @ApiOperation(value = "用车申请：关键词输入提示地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "region", value = "范围限制条件（例如：苏州）", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "keyword", value = "用户输入的关键词（例如：格上）", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryLocations")
    public ResponseResult<List<LocationList>> queryLocations(@RequestParam(name = "region")String region,
                                                             @RequestParam(name = "keyword")String keyword) throws Exception {
        Map<String, Object> map = LocationUtils.getLocations(region,keyword);
        String k = map.get("data").toString();
        JSONArray kObject = JSONArray.fromObject(k);
        List<LocationList> list = Lists.newArrayList();
        for (int i=0; i<kObject.size(); i++){
            LocationList locationList = new LocationList();
            locationList.setTitle(kObject.getJSONObject(i).getString("title"));
            locationList.setAddress(kObject.getJSONObject(i).getString("address"));
            List<Location> locations = Lists.newArrayList();
            Location location = new Location();
            location.setLat(kObject.getJSONObject(i).getJSONObject("location").getDouble("lat"));
            location.setLng(kObject.getJSONObject(i).getJSONObject("location").getDouble("lng"));
            locations.add(location);
            locationList.setLocations(locations);
            list.add(locationList);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", list);
    }

    @ApiOperation(value = "用车申请：经纬度计算距离")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "from", value = "起点坐标（例如：from=31.288530854,120.666760427）", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "to", value = "终点坐标（例如：from=31.35458833,120.700719984）", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryDistance")
    public ResponseResult<Distance> queryDistance(@RequestParam(name = "from")String from,
                                                              @RequestParam(name = "to")String to) throws Exception {
        Map<String, Object> map = LocationUtils.getDistance(from,to);
        Distance distance = new Distance();
        String s1 = map.get("elements").toString();
        String s = s1.substring(14).replace("}]}]","}");
        JSONObject jsonObject = JSONObject.fromObject(s);
        Double d = jsonObject.getDouble("distance")/1000;//米转为公里
        distance.setDistance(d);
//        distance.setDistance(d+"公里");
//        distance.setDistance(jsonObject.getDouble("distance"));
//        distance.setDuration(jsonObject.getDouble("duration"));
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", distance);
    }

    @ApiOperation(value = "用车申请：获取用车类别、牌照地区、车辆选择类别")
    @ApiImplicitParam(name = "itemType", value = "用车类别：833,牌照地区：810,车辆选择类别：231",required = true,dataType ="int",paramType = "path")
    @GetMapping(value = "queryCarArea")
    public ResponseResult<List<CarAreaList>> queryCarArea(@RequestParam(name = "itemType") Integer itemType){
        List<CarAreaList> lists = itemCodeService.selectCarArea(itemType);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "用车申请：获取使用部门数据")
    @ApiImplicitParam(name = "userAuto",value = "登录者userAuto",required = false,dataType = "long",paramType = "path")
    @GetMapping(value = "queryCarApplyOrg")
    public ResponseResult<List<CarApplyOrg>> queryCarApplyOrg(@RequestParam(name = "userAuto",required = false) Long userAuto){
        List<CarApplyOrg> lists = vEmpService.selectCarApplyOrg(userAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "用车申请：获取使用人数据")
    @ApiImplicitParam(name = "orgAuto",value = "使用部门序号",required = true,dataType = "long",paramType = "path")
    @GetMapping(value = "queryCarApply")
    public ResponseResult<List<CarApplyList>> queryCarApply(@RequestParam(name = "orgAuto") Long orgAuto){
        List<CarApplyList> lists = vEmpService.selectCarApply(orgAuto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "用车申请、车辆归还：获取申请列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carApplicationAuto",value = "用车申请单号",required = false,dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "appUser",value = "申请人序号(登录人userAuto)",required = true,dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "username",value = "使用人",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "makNo",value = "车辆号码",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "planStartDT",value = "开始时间",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "planEndDT",value = "结束时间",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "statusN",value = "状态:已删除、驳回、送件、核准、待取车、出车、还车",required = false,dataType = "String",paramType = "path")
    })
    @GetMapping(value = "queryUserCar")
    public ResponseResult<List<UserCarList>> queryUserCar(@RequestParam(name = "carApplicationAuto",required = false) Long carApplicationAuto,
                                                          @RequestParam(name = "appUser") Long appUser,
                                                          @RequestParam(name = "username",required = false) String username,
                                                          @RequestParam(name = "planStartDT",required = false) String planStartDT,
                                                          @RequestParam(name = "planEndDT",required = false) String planEndDT,
                                                          @RequestParam(name = "makNo",required = false) String makNo,
                                                          @RequestParam(name = "statusN",required = false) String statusN){
        UseCarQueryParam useCarQueryParam = new UseCarQueryParam(carApplicationAuto,appUser,username,makNo,planStartDT,planEndDT,statusN);
        List<UserCarList> lists = carApplicationService.selectUserCar(useCarQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无申请数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "用车申请、车辆归还：获取具体申请明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginUserID",value = "登录人userAuto",required = true,dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "carApplicationAuto",value = "用车申请单号",required = true,dataType = "long",paramType = "path")
    })
    @GetMapping(value = "queryApplyAndBack")
    public ResponseResult<CheckOne> queryApplyAndBack(@RequestParam(name = "loginUserID") Long loginUserID,
                                                    @RequestParam(name = "carApplicationAuto") Long carApplicationAuto){
        CheckOne checkOne = carApplicationService.selectApplyAndBack(loginUserID, carApplicationAuto);
        if (checkOne == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",checkOne);
    }

    @ApiOperation(value = "用车审核：获取签核明细数据")
    @ApiImplicitParam(name = "carApplicationAuto",value = "用车申请单号",required = false,dataType = "long",paramType = "path")
    @GetMapping(value = "queryUseCarDoc")
    public ResponseResult<List<UseCarDoc>> queryUseCarDoc(@RequestParam(name = "carApplicationAuto",required = false) Long carApplicationAuto){
        List<UseCarDoc> list = carApplicationService.selectUseCarDoc(carApplicationAuto);
        if (list.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无数据",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",list);
    }

    @ApiOperation(value = "用车申请：判断是否假日用车、计算用车时间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime",value = "开始时间",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "endTime",value = "结束时间",required = true,dataType = "String",paramType = "path")
    })
    @GetMapping(value = "queryByTime")
    public ResponseResult<Holiday> queryByTime(@RequestParam(name = "startTime") String startTime,
                                               @RequestParam(name = "endTime") String endTime) throws ParseException {
        if(startTime == null || endTime == null){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"提示：使用时间不能为空",null);
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date1 = format.parse(startTime);
        Date date2 = format.parse(endTime);
        if (date1.after(date2)){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"开始时间必须小于结束时间",null);
        }
        Holiday holiday = carApplicationService.selectByTime(date1, date2);
        if (holiday.getNum() > 0){
            holiday.setIsHoliday(1);
        }else {
            holiday.setIsHoliday(0);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",holiday);
    }

    @ApiOperation(value = "用车申请：自动配车、用车审核：获取车辆列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oilName",value = "动力方式",required = false,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "bsTypeN",value = "排挡方式",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "carArea",value = "牌照地区",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "mileage",value = "续航里程",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "type",value = "查询类别：1 自动配车 2获取车辆列表",required = true,dataType = "String",paramType = "path")
    })
    @GetMapping(value = "queryOrgCar")
    public ResponseResult<List<OrgCarList>> queryOrgCar(@RequestParam(name = "oilName",required = false) String oilName,
                                                        @RequestParam(name = "bsTypeN") String bsTypeN,
                                                        @RequestParam(name = "carArea") String carArea,
                                                        @RequestParam(name = "mileage") BigDecimal mileage,
                                                        @RequestParam(name = "type") Integer type){
        OrgCarQueryParam orgCarQueryParam = new OrgCarQueryParam(oilName,bsTypeN,carArea,mileage,type);
        List<OrgCarList> lists = orgCarService.selectOrgCar(orgCarQueryParam);
        if (lists.size() == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"暂无匹配车辆",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }

    @ApiOperation(value = "用车申请：送件(此接口如要测试请联系后端)")
    @PostMapping(value = "applyInsert")
    public ResponseResult<String> ApplyInsert(@ApiParam(value = "用车申请：新增数据")@Valid @RequestBody OutCarApplyParamDto outCarApplyParamDto){
        if (outCarApplyParamDto.getPlanStartDT().after(outCarApplyParamDto.getPlanEndDT())){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"开始时间必须小于结束时间",null);
        }
        ApplyJudge applyJudge = carApplicationService.selectSC(outCarApplyParamDto.getAppUser());
        ApplyJudge applyJudge2 = carApplicationService.selectNum(outCarApplyParamDto.getAppUser(),new Date());
        if (applyJudge.getChiefId() < 2) {
            if (applyJudge.getIsSalesDep()==1 && outCarApplyParamDto.getAppType()==1 && outCarApplyParamDto.getCarBaseAuto() == 0) {
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"公务车申请时车号不能为空",null);
            }
            if (applyJudge.getIsSalesDep()==1 && outCarApplyParamDto.getAppType()==1 && applyJudge.getChiefId()<=1) {
                if (applyJudge2.getNum() < 1){
                    return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"行程安排未申请或未签核",null);
                }
            }
        }

        OutCarApplyDto outCarApplyDto = new OutCarApplyDto();
        BeanUtils.copyProperties(outCarApplyParamDto,outCarApplyDto);

        //捕获空指针异常
        try{
            //判断查无签核流程设定!请联系系统管理员!
            ApplyJudge applyJudge3 = carApplicationService.selectErrorN(outCarApplyDto);
            if (applyJudge3.getErrorN() != null){
                return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,applyJudge3.getErrorN(),null);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        Integer i = carApplicationService.applyInsert(outCarApplyDto);
        if (i == 0){
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"送件失败",null);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"送件成功",null);
    }

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

    @ApiOperation(value = "车辆安排：领取钥匙(此接口如要测试请联系后端)")
    @PutMapping(value = "getKeyUpdate")
    public ResponseResult<String> GetKeyUpdate(@ApiParam(value = "车辆安排：领取钥匙数据")@Valid @RequestBody GetKeyParamDto getKeyParamDto){
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
}
