package com.dpccours.system;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
//防止自己作为注册中心自己进行注册111
@EnableEurekaClient
//作为注册中心的客户端
@ComponentScan("com.dpccours")
@MapperScan("com.dpccours.system.mapper")
public class SystemApplication {
    //Spring cloud  默认继承了slf4j框架，它定义了一些日志接口，规范日志输出，真正的实现手机logback和log4g，
	//本项目实的代码slf4j的代码
	//引入日志对象logger
	private static final Logger LOG= LoggerFactory.getLogger(SystemApplication.class);
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SystemApplication.class);
		Environment env = app.run(args).getEnvironment();
		LOG.info("System启动成功！！");
		LOG.info("System地址：\thttp://127.0.0.1:{}",env.getProperty("server.port"));
	}

}
