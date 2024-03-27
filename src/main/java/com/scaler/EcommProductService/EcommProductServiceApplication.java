package com.scaler.EcommProductService;

import com.scaler.EcommProductService.service.InitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class EcommProductServiceApplication implements CommandLineRunner {
public class EcommProductServiceApplication{

	//@Autowired
	//InitDataService initDataService;

	public static void main(String[] args){
		SpringApplication.run(EcommProductServiceApplication.class, args);
	}

	//@Override
	//public void run(String... args) throws Exception {
	//	initDataService.initData();
	//}
}
