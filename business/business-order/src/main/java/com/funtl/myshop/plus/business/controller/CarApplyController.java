package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.dto.GetLocation;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.commons.utils.MapperUtils;
import com.funtl.myshop.plus.controller.LocationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Api(tags = "车队管理模块相关操作")
@RestController
@RequestMapping(value = "carApply")
public class CarApplyController {
    @ApiOperation(value = "经纬度转地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lng", value = "经度", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "lat", value = "纬度", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "queryLocation")
    public ResponseResult<GetLocation> queryLocation(@RequestParam(name = "lng")String lng,
                                                        @RequestParam(name = "lat")String lat) throws Exception {
        Map<String, Object> map = LocationUtils.getLocation(lng, lat);
        GetLocation getLocation = new GetLocation();
        getLocation.setProvince((String) map.get("province"));
        getLocation.setNation((String) map.get("nation"));
        getLocation.setCity((String) map.get("city"));
        getLocation.setProvinceCode((String) map.get("provinceCode"));
        getLocation.setCityCode((String) map.get("cityCode"));
        getLocation.setNationCode((String) map.get("nationCode"));
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询成功", getLocation);
    }

}
