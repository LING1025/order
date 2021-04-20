package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.FileInfo;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.controller.TBoxLog;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Api(tags = "TBox相关操作")
@RestController
@RequestMapping(value = "TBox")
public class TBoxLogController {

    @ApiOperation(value = "将logNew数据插入到TBoxLog表")
    @PostMapping(value = "logNew")
    public ResponseResult<List<String>> insert(){
        TBoxLog.getTBoxLog();
        //todo:解析logNew文件插入数据库
        List<String> list = Lists.newArrayList();
        String line = null;
        File f = new File("D:\\twoWork\\logNew.txt");
        try{
            // 读取“log.txt”文件
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String type = line.split(",")[1];//指令类型
                String deviceId = line.split(",")[0];//设备号
                String logString = "$E6,"+line;//记录AT指令
                if (type.equals("01") || type.equals("24")){
                    list.add("$E6,"+line);
                }
            }
            return new ResponseResult<>(BusinessStatus.OK.getCode(), "保存成功", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseResult<>(BusinessStatus.FAIL.getCode(), "保存失败", null);
    }
}
