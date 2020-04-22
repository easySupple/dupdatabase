package com.lz.yr;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
//@SpringBootApplication
@MapperScan({"com.lz.yr.master.mapper","com.lz.yr.second.mapper"})
@ComponentScan(basePackages = "com.lz.yr")
public class YrApplication {

	public static void main(String[] args) {
		SpringApplication.run(YrApplication.class, args);
	}

}
