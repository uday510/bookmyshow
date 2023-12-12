package com.lld.bookmyshow;
import models.BaseModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication {
	public static void main(String[] args) {
		BaseModel baseModel = new BaseModel();
		SpringApplication.run(BookMyShowApplication.class, args);
	}
}
