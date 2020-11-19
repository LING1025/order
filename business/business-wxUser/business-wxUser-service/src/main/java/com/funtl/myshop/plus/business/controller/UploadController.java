package com.funtl.myshop.plus.business.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.UUID;

@Api(tags = "上传文件相关操作")
@RestController
@RequestMapping(value = "upload")
public class UploadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @ApiOperation(value = "上传图片")
    @PostMapping(value = "picture")
    public String uploadPicture(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
                System.out.println("访问图片路径:" + filePath);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return filePath;
    }
}
