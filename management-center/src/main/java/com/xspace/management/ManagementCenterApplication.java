package com.xspace.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:/dubbo/*.xml" })

public class ManagementCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementCenterApplication.class, args);
	}

}
