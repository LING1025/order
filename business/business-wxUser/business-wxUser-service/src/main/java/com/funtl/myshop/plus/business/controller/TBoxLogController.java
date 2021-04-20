package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.controller.TBoxLogUtils;
import com.funtl.myshop.plus.provider.domain.TBoxLog;
import com.funtl.myshop.plus.provider.service.TBoxLogService;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.List;

@Api(tags = "TBox相关操作")
@RestController
@RequestMapping(value = "TBox")
public class TBoxLogController {

    @Reference(version = "1.0.0")
    private TBoxLogService tBoxLogService;

    /*此接口无需调用
    @ApiOperation(value = "将logNew数据插入到TBoxLog表")
    @PostMapping(value = "logNew")
    public ResponseResult<List> insert(){
//        TBoxLogUtils.getTBoxLog();//数据量太大无法插入，不可超过2000条，所以注释
        List<String> list = Lists.newArrayList();
        String line = null;
        File f = new File("D:\\twoWork\\logNew.txt");
        try{
            // 读取“log.txt”文件
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<TBoxLog> tBoxLogList = Lists.newArrayList();
            while ((line = bufferedReader.readLine()) != null) {
                String type = line.split(",")[1];//指令类型
                if (type.equals("01") || type.equals("24")){
                    list.add("$E6,"+line);
                    String deviceId = line.split(",")[0];//设备号
                    String logString = "$E6,"+line;//记录AT指令
                    tBoxLogList.add(TBoxLog.of().setType(type).setDeviceId(deviceId)
                            .setLogString(logString).setCreateDateTime(new Date())
                    .setCarBaseAuto(0L));
                }
            }
            Integer i = tBoxLogService.insertList(tBoxLogList);
            if (i == 0){
                return new ResponseResult<>(BusinessStatus.FAIL.getCode(), "设备记录保存失败", null);
            }
            return new ResponseResult<>(BusinessStatus.OK.getCode(), "保存成功", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<>(BusinessStatus.FAIL.getCode(), "保存失败", null);
    }*/
}
