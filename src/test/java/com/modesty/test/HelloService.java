package com.modesty.test;

import org.springframework.stereotype.Service;

/**
* @author Modesty
* @Version 2020年4月5日 下午10:16:57
*/
@Service
public class HelloService {
	public String sayHello(String name) {
		return "Hello "+name+" !";
	}
}


/**
* Notes
*/
