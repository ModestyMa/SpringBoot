package com.modesty;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

//import de.codecentric.boot.admin.config.EnableAdminServer;



/**
 * @author Modesty
 * @version 
 */

@SpringBootApplication
@EnableJms
@EnableScheduling
@EnableBatchProcessing
//@EnableAdminServer
public class SpringStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringStartApplication.class, args);
	}
	
	@Bean
	Queue queue() {
		return new ActiveMQQueue("AMQ");
	}
}


/*
 * @EnableAutoConfiguration	开启自动化配置
 * @ComponentScan	将配置进行扫描进去	(扫描@Service,@Repository,@Component,@Controller,@RestController,@Configure)
 * @Configure		表明这是一个配置类
 * @SpringBootApplication 代替 @EnableAutoConfiguration		@ComponentScan	@Configure
 * @EnableAutoConfiguration(exclude={__.class})  去除某个自动化诶之
 */
