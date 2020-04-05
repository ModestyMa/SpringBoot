package com.modesty.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.modesty.pojo.po.Books;
import com.modesty.service.BooksService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @author Modesty
* @Version 2020年4月5日 下午8:24:31
*/
@RestController
@Api("Books使用JPA测试程序")
@RequestMapping("/booksJPA")
public class BooksJPAController {
	@Autowired
	BooksService booksService;
	
	@PostMapping("/bookAdd")
	@ApiOperation(value = "测试books JPA",notes="测试books add")
	public void bookAdd(Books books) {
		booksService.addBooks(books);
	}
	
	@PostMapping("/bookSeachByAuthorName")
	@ApiOperation(value = "测试books JPA",notes="测试books bookSeachByAuthorName")
	public String bookSeachByAuthorName(String authorName) {
		List<Books> books = booksService.getBooksByAuthorName(authorName);
		return JSON.toJSONString(books);
	}
	
	@PostMapping("/bookSeachByBookName")
	@ApiOperation(value = "测试books JPA",notes="测试books bookSeachByBookName")
	public String bookSeachByBookName(String bookName) {
		List<Books> books = booksService.getBooksByBookName(bookName);
		return JSON.toJSONString(books);
	}
	
	@PostMapping("/bookUpdateAuthorByName")
	@ApiOperation(value = "测试books JPA",notes="测试books bookUpdateAuthorByName")
	public void bookUpdateAuthorByName(String author,String bookName) {
		booksService.updateAuthorByName(author, bookName);
	}
}


/**
* Notes
*/
