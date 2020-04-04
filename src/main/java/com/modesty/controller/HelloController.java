package com.modesty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api("第一个测试程序")
public class HelloController {
	
	@GetMapping("/hello")
	@ApiOperation(value = "测试hello",notes="测试notes1")
	public String hello() {
		return "hello,Spring Boot";
	}


}
