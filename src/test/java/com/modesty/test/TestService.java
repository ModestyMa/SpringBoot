package com.modesty.test;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
* @author Modesty
* @Version 2020年4月5日 下午10:18:17
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {
	@Autowired
	HelloService helloService;
	
	@Test
	public void test() {
		String hello = helloService.sayHello("Modesty");
		Assert.assertThat(hello, Matchers.is("Hello Modesty !"));
	}
}


/**
* Notes
*/
