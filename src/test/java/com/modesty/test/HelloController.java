package com.modesty.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.modesty.pojo.vo.Book;

/**
* @author Modesty
* @Version 2020年4月5日 下午10:21:54
*/
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello "+ name + " !";
	}
	
	@PostMapping("/book")
	public String addHello(@RequestBody Book book) {
		return book.toString();
	}
}


/**
* Notes
*/
