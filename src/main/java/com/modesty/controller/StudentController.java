package com.modesty.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.modesty.pojo.cachePo.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @author Modesty
* @Version 2020年4月6日 下午2:13:32
*/

@RestController
@Api("NOSQL测试程序")
@RequestMapping("/student")
public class StudentController {
	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class); 
	
	@GetMapping("/getStudent")
	@ApiOperation(value = "从缓存中取出Student的值",notes="")
	public String getStudent() {
		ValueOperations<String, String> ops1 = stringRedisTemplate.opsForValue();
		ops1.set("name", "马谦理");
		String name = ops1.get("name");
		log.info("redis 中取出name:"+name);
		
		ValueOperations ops2 = redisTemplate.opsForValue();
		Student s = new Student();
		s.setName("堵秋莹");
		s.setAge("35");
		ops2.set("student", s);
		Student stu = (Student) ops2.get("student");
		
		return JSON.toJSONString(stu);
	}
}


/**
* Notes
*/
