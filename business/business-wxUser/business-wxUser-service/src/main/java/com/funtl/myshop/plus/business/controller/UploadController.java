package com.funtl.myshop.plus.business.controller;

import com.funtl.myshop.plus.business.BusinessStatus;
import com.funtl.myshop.plus.business.dto.FileInfo;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

@Api(tags = "上传文件相关操作")
@RestController
@RequestMapping(value = "upload")
public class UploadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    /**
     * 上传图片且用返回路径查看
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "上传图片")
    @PostMapping(value = "picture")
    public ResponseResult<FileInfo> uploadPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filePath = "";
        request.setCharacterEncoding("utf-8"); //设置编码
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        File dir = new File(realPath);
        //文件目录不存在，就创建一个
        if (!dir.isDirectory()) {
            dir.mkdirs();
        }
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            //获取formdata的值
            Iterator<String> iterator = req.getFileNames();

            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());
                String fileName = file.getOriginalFilename();
                //真正写到磁盘上
                String uuid = UUID.randomUUID().toString().replace("-", "");
                String kzm = fileName.substring(fileName.lastIndexOf("."));
                String filename = uuid + kzm;
                File file1 = new File(realPath + filename);
                OutputStream out = new FileOutputStream(file1);
                out.write(file.getBytes());
                out.close();
                filePath = request.getScheme() + "://" +
                        request.getServerName() + ":"
                        + request.getServerPort()
                        + "/uploadFile/" + filename;
//                System.out.println("访问图片路径:" + filePath);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return new ResponseResult<>(BusinessStatus.OK.getCode(), "图片上传成功", new FileInfo(filePath));
    }


    @ApiOperation(value = "上传附件")
    @PostMapping("/file")
    public ResponseResult<FileInfo> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseResult<>(BusinessStatus.FAIL.getCode(),"上传失败，请选择文件",null);
        }
        if (file.getSize() > 10*1024*1024){
            return new ResponseResult<>(BusinessStatus.FAIL.getCode(),"上传文件不得大于10MB",null);
        }
        String fileName = file.getOriginalFilename();
        String filePath = "E:\\下载\\testUpFile\\";//下载路径
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return new ResponseResult<>(BusinessStatus.OK.getCode(),"上传成功",new FileInfo(filePath+fileName));
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return new ResponseResult<>(BusinessStatus.FAIL.getCode(),"上传失败！",null);
    }


    @ApiOperation(value = "上传附件")
    @PostMapping("/uploadFile")
    public ResponseResult<FileInfo> upload(@RequestParam("file") MultipartFile file, HttpServletRequest req) {
        if (file.isEmpty()) {
            return new ResponseResult<>(BusinessStatus.FAIL.getCode(),"上传失败，请选择文件",null);
        }
        if (file.getSize() > 10*1024*1024){
            return new ResponseResult<>(BusinessStatus.FAIL.getCode(),"上传文件不得大于10MB",null);
        }
        String fileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String kzm = fileName.substring(fileName.lastIndexOf("."));
        String newName = uuid + kzm;
        File dest = new File(newName);
        try{
            file.transferTo(dest);
            String filePath = req.getScheme() + "://" +
                    req.getServerName() + ":" +
                    req.getServerPort() + "/uploadFile2/" +
                    newName;
            return new ResponseResult<>(BusinessStatus.OK.getCode(),"上传成功",new FileInfo(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseResult<>(BusinessStatus.FAIL.getCode(),"上传失败",null);
    }
}
