package com.newer.supervise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableTransactionManagement
@MapperScan("com.newer.supervise.mapper")

public class SuperviseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperviseApplication.class, args);
	}

}
