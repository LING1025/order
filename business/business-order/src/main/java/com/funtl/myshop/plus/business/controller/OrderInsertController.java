package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessException;
import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.WorkFlowDocService;
import com.funtl.myshop.plus.provider.domain.MasterList;
import com.funtl.myshop.plus.provider.domain.WorkFlowDoc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "直租、回租试算签核相关新增操作")
@RestController
@RequestMapping(value = "orderInsert")
public class OrderInsertController {
    @Reference(version = "1.0.0")
    private WorkFlowDocService workFlowDocService;


}
