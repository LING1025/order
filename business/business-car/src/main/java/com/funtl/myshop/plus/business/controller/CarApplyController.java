package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.Distance;
import com.funtl.myshop.plus.business.dto.Location;
import com.funtl.myshop.plus.business.dto.LocationList;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.controller.LocationUtils;
import com.funtl.myshop.plus.provider.api.ItemCodeService;
import com.funtl.myshop.plus.provider.domain.CarAreaList;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "车队管理模块相关操作")
@RestController
@RequestMapping(value = "useCar")
public class CarApplyController {
    @Reference(version = "1.0.0")
    private ItemCodeService itemCodeService;

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

    @ApiOperation(value = "用车申请：获取用车类别、牌照地区、车辆选择、事由说明类别、费用类别、付款别、网银类别")
    @ApiImplicitParam(name = "itemType", value = "用车类别：833,牌照地区：810,车辆选择类别：231,事由说明：865，费用类别：903,付款别：899，网银类别：897",required = true,dataType ="int",paramType = "path")
    @GetMapping(value = "queryCarArea")
    public ResponseResult<List<CarAreaList>> queryCarArea(@RequestParam(name = "itemType") Integer itemType){
        List<CarAreaList> lists = itemCodeService.selectCarArea(itemType);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK,"查询成功",lists);
    }
}