package com.modesty.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.modesty.jms.JmsComponent;
import com.modesty.pojo.vo.Message;

/**
* @author Modesty
* @Version 2020年4月6日 下午11:25:00
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	JmsComponent jmsComponent;
	
	@Test
	public void contextLoads() {
		Message msg = new Message();
		msg.setContent("hello jms");
		msg.setDate(new Date());
		jmsComponent.send(msg);
	}
}


/**
* Notes
*/
