package com.xspace.accountcenter;

import com.xspace.accountcenter.kafka.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AccountCenterServiceApplication {
	public static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	public static void main(String[] args) {
		logger.info("111:{}",args);
		SpringApplication.run(AccountCenterServiceApplication.class, args);
	}

}
