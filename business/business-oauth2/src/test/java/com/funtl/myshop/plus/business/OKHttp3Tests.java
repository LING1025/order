package com.funtl.myshop.plus.business;

import okhttp3.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OKHttp3Tests {
    @Resource
    public BCryptPasswordEncoder passwordEncoder;

    @Test
    public void test() throws NoSuchAlgorithmException {
        String Salt = "/QJI/OYzoWZAiclktXY/sA==";
        System.out.println(Salt);
        //定义一个密码，这里就不从数据库取了
        String p = "123456";
        //打印md5加密后的密码
        System.out.println("md5加密结果："+DigestUtils.md5DigestAsHex(p.getBytes()));
        //登录时，从页面获取密码与数据库密码进行比较，这里就不获取，直接定义
        String password = DigestUtils.md5DigestAsHex(p.getBytes());//数据库保存的密码
        String pwd = "123456";//从页面获取的密码1
        String pwd2 = "111111";//从页面获取的密码2
        //使用md5验证
        System.out.println(DigestUtils.md5DigestAsHex(pwd.getBytes()).equals(password));
        System.out.println(DigestUtils.md5DigestAsHex(pwd2.getBytes()).equals(password));

    }

    @Test
    public void testGet(){
        String url = "https://www.baidu.com";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String url = "http://localhost:9001/oauth/token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("username", "admin")
                .add("password", "123456")
                .add("grant_type", "password")
                .add("client_id", "client")
                .add("client_secret", "secret")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
