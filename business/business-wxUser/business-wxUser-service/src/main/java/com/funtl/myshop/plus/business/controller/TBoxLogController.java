package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.FileInfo;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.controller.TBoxLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "TBox相关操作")
@RestController
@RequestMapping(value = "TBox")
public class TBoxLogController {

    @ApiOperation(value = "将LogNew数据插入到数据库")
    @PostMapping(value = "logNew")
    public ResponseResult<String> insert(){
        TBoxLog.getTBoxLog();
        return new ResponseResult<>(BusinessStatus.OK.getCode(), "保存成功", null);
    }
}
