package com.modesty.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api("第一个测试程序")
public class HelloController {
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/hello")
	@ApiOperation(value = "测试hello",notes="测试notes1")
	public String hello() {
		return "hello,Spring Boot";
	}

	@GetMapping("/hello1")
	@ApiOperation(value = "测试hello1",notes="测试全局返回Model获取info数据")
	public String hello1(Model model) {
		Map<String, Object> map = model.asMap();
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			Object value = map.get(key);
			log.info(key+">>>>"+ value);
		}
		return "hello,Spring Boot";
	}

}
