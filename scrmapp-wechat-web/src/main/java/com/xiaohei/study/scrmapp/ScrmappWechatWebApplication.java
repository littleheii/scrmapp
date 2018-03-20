package com.xiaohei.study.scrmapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class ScrmappWechatWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrmappWechatWebApplication.class, args);
	}
}
