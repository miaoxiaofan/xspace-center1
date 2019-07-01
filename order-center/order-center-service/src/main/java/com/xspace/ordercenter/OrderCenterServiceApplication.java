package com.xspace.ordercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:/dubbo/*.xml", "classpath*:/spring/spring-aop-transaction.xml" })
@MapperScan("com.xspace.ordercenter.dao")
public class OrderCenterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderCenterServiceApplication.class, args);
	}

}
