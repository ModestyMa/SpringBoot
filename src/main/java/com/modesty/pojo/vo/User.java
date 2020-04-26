package com.modesty.pojo.vo;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
* @author Modesty
* @Version 2020年4月7日 上午1:58:34
*/

@Data
public class User {
	private Integer id;
	
	@Size(min = 5,max = 10,message = "用户名长度应该在5到10之间")
	private String name;
	
	@NotNull(message = "用户地址不能为空")
	private String address;
	
	@DecimalMin(value = "1",message = "年龄输入不正确过小")
	@DecimalMax(value = "200",message = "年龄输入不正确过大")
	private Integer age;
	
	@Email(message = "邮箱不能为空")
	@NotNull(message = "邮箱格式不正确")
	private String email;
}


/**
* Notes
*/
