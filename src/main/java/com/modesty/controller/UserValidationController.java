package com.modesty.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modesty.pojo.vo.User;

import io.swagger.annotations.Api;

/**
* @author Modesty
* @Version 2020年4月7日 上午1:55:11
*/
@RestController
@Api("测试Validation程序")
@RequestMapping("/user")
public class UserValidationController {
	@PostMapping("/addUser")
	public List<String> addUser(@Validated User user,BindingResult result){
//	public List<String> addUser( User user,BindingResult result){
		List<String> errors = new ArrayList<String>();
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError error : allErrors) {
				errors.add(error.getDefaultMessage());
			}
		}
		return errors;
	}
}


/**
* Notes
*/
