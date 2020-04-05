package com.modesty.config.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
* @author Modesty
* @Version 2020年4月4日 下午5:10:00
*/

@ControllerAdvice
public class GlobalConfig {
	@ModelAttribute(value = "info")
	public Map<String,String> userInfo(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userName", "罗贯中");
		map.put("gender", "男");
		return map;
	} 
	
	@InitBinder("b")
	public void init1(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("b.");
	}
	
	@InitBinder("a")
	public void init2(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("a.");
	}
}


/**
* Notes
*/
