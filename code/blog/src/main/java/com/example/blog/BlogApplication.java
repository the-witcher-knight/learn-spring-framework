package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BlogApplication.class, args);

		// Lấy ra bean GirlService
		GirlService girlService = context.getBean(GirlService.class);
		// Lấu ra random một cô gái từ tầng service
		Girl girl = girlService.getRandomGirl();
		// In ra màn hình
		System.out.println(girl);

	}


}
