package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BlogApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BlogApplication.class, args);

		Outfit outfit = context.getBean(Outfit.class);

		System.out.println("Instance: " + outfit);

		outfit.wear();

		Girl girl = context.getBean(Girl.class);

		System.out.println("Girl Instance: " + girl);

		System.out.println("Girl Outfit: " + girl.outfit);

		girl.outfit.wear();

	}


}
