package com.shisw.archerBackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shisw.archerBackend.mapper")
public class ArcherBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArcherBackendApplication.class, args);
	}

}
