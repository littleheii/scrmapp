package com.xiaohei.study.scrmapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaohei.study.scrmapp.mapper")
public class ScrmappProductProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrmappProductProviderApplication.class, args);
	}
}
