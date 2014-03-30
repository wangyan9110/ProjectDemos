package org.yywang.springbootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}

@RestController
class HelloController{
	
	@RequestMapping("/hello/{name}")
	String hello(@PathVariable String name){
		return "Hello,"+name+"!";
	}
	
}
