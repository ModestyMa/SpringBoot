package com.modesty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author Modesty
 * @version 
 */

@SpringBootApplication
public class SpringStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringStartApplication.class, args);
	}
}


/*
 * @EnableAutoConfiguration	开启自动化配置
 * @ComponentScan	将配置进行扫描进去	(扫描@Service,@Repository,@Component,@Controller,@RestController,@Configure)
 * @Configure		表明这是一个配置类
 * @SpringBootApplication 代替 @EnableAutoConfiguration		@ComponentScan	@Configure
 */
