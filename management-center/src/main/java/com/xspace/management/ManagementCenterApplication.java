package com.xspace.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@ImportResource({ "classpath:/dubbo/*.xml" })

@EnableRetry

public class ManagementCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementCenterApplication.class, args);
	}

}
