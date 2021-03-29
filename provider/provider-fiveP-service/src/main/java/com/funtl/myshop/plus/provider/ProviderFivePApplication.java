package com.funtl.myshop.plus.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.funtl.myshop.plus.provider.mapper")
public class ProviderFivePApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderFivePApplication.class,args);
    }
}
