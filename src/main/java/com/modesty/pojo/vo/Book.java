package com.modesty.pojo.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
* @author Modesty
* @Version 2020年4月4日 下午3:48:21
*/
@Data
public class Book {
	private Integer id;
	private String name;
	private String author;
	@JsonIgnore
	private Float price;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date publicationDate;
}


