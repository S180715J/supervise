package com.newer.supervice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)

@MapperScan("com.newer.supervice.mapper")

public class SuperviseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperviseApplication.class, args);
	}

}
