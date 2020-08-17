package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@RestController
public class BlogApplication {

	public static void main(String[] args) {
		System.out.println("> Trước khi IoC Container được khởi tạo");
		ApplicationContext context = SpringApplication.run(BlogApplication.class, args);
		System.out.println("> Sau khi IoC Container được khởi tạo");

		// Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
		// dấu @Component.

		Girl girl = context.getBean(Girl.class);

		System.out.println("> Trước khi IoC Container destroy Girl");
		((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(girl);
		System.out.println("> Sau khi IoC Container destroy Girl");

	}


}
