package com.modesty.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.modesty.pojo.vo.Author;
import com.modesty.pojo.vo.Book;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @author Modesty
* @Version 2020年4月4日 下午3:52:41
*/

@RestController
@Api("thymeleaf测试程序")
@RequestMapping("/book")
public class BookController {
	@GetMapping("/books")
	@ApiOperation(value = "测试books",notes="测试thymeleaf和lombak使用")
	public ModelAndView books() {
		List<Book> books = new ArrayList<Book>();
		Book b1 = new Book();
		b1.setId(1);
		b1.setAuthor("罗贯中");
		b1.setName("三国演义");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("books",books);
		mv.setViewName("books");
		return mv;
	}
	
	@GetMapping("/book")
	@ApiOperation(value = "测试bookJSON",notes="JSON转换器的变化")
	public Book book() {
		Book b1 = new Book();
		b1.setId(1);
		b1.setAuthor("罗贯中");
		b1.setName("三国演义");
		b1.setPrice(30f);
		b1.setPublicationDate(new Date());
		return b1;
	}
	
	@GetMapping("/bookAndAuthor")
	@ApiOperation(value = "测试请求参数预处理",notes="当参数有同名的时候会,通过参数预处理解决")
	public String bookAndAuthor(@ModelAttribute("b") Book book,@ModelAttribute("a") Author author) {
		return book.toString()+">>>>"+author.toString();
	}
	
	@PostMapping("/bookCros")
	@CrossOrigin(value = "http://localhost:8082",maxAge = 1800,allowedHeaders = "*")
	@ApiOperation(value = "测试跨域请求处理",notes="解决前端跨域请求配置")
	public String bookCros(String name) {
		return name;
	}
}


/**
 * Notes
 * @RestController代替@Contoller和@ResponseBody
 * @CrossOrigin 中value代表支持的域,maxAge表示探测请求的有效期/有效期过后才会发送探测请求,allowedHeader表示允许的请求头
 */

