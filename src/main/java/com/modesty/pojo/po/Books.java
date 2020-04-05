package com.modesty.pojo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

/**
* @author Modesty
* @Version 2020年4月5日 下午7:37:24
*/
@Data
@Entity(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "author",nullable = false)
	private String author;
	
	@Column(name = "price",nullable = false)
	private Float price;
	
	@Transient
	private String description;
}


/**
* Notes
* @Transient 表示注解时属性被忽略
*/
