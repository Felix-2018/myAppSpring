package com.FMSv2.FMSv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
@EnableConfigurationProperties
public class FmSv2Application {
	 private static ConfigurableApplicationContext fMSv2Context;
	public static void main(String[] args) {
		FmSv2Application.fMSv2Context = SpringApplication.run(FmSv2Application.class, args);
	}

}

