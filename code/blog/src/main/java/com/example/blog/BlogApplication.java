package com.example.blog;

import com.example.blog.other.Polygons;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ConfigurableApplicationContext;

@ComponentScan("com.example.blog.other")
@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BlogApplication.class, args);

		try {
			Girl girl = context.getBean(Girl.class);
			System.out.println(girl.toString());
		}catch (Exception ex){
			System.out.println("Girl not exists: " + ex);
		}

		try {
			Polygons polygons = context.getBean(Polygons.class);
			System.out.println(polygons.toString());
		}catch (Exception ex){
			System.out.println("Polygons not exists: " + ex);
		}
	}


}
