package com.xiaohei.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xiaohei.study.scrmapp.mapper")
public class ScrmappOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrmappOrderProviderApplication.class, args);
    }
}
