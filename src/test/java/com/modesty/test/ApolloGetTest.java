package com.modesty.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

/**
* @author Modesty
* @Version 2020年5月1日 下午5:11:31
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApolloGetTest {
	@Test
	public void test1() {
		Config appConfig = ConfigService.getAppConfig();
		String property = appConfig.getProperty("sms.enable", "");
		System.out.println("默认读取配置:"+property);
	}
	
	@Test
	public void test2() {
		Config appConfig = ConfigService.getConfig("apache-activemq");
		String property = appConfig.getProperty("spring.activemq.broker-url", "");
		System.out.println("namespace读取配置:"+property);
	}
	
	public static void main(String[] args) {
		Config appConfig = ConfigService.getAppConfig();
		
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			String property = appConfig.getProperty("sms.enable", "");
			System.out.println(property);
		}
		
	}
}


/**
* Notes	-Dapp.id=springboot-demo -Denv=DEV -Dapollo.configService=http://119.3.167.2:8080 -Ddev_meta=http://119.3.167.2:8080
*/
