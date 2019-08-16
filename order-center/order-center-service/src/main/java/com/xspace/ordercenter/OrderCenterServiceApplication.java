package com.xspace.ordercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource({ "classpath:/dubbo/*.xml" })
@MapperScan("com.xspace.ordercenter.dao")
@EnableScheduling
@EnableCaching
public class OrderCenterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderCenterServiceApplication.class, args);
	}

}
