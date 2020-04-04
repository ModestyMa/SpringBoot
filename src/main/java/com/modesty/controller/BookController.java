package com.modesty.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.modesty.pojo.vo.Book;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @author Modesty
* @Version 2020年4月4日 下午3:52:41
*/

@RestController
@Api("thymeleaf测试程序")
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
	@ApiOperation(value = "测试bookJSON",notes="")
	public Book book() {
		Book b1 = new Book();
		b1.setId(1);
		b1.setAuthor("罗贯中");
		b1.setName("三国演义");
		b1.setPrice(30f);
		b1.setPublicationDate(new Date());
		return b1;
	}
}


/**
 * Notes
 * @RestController代替@Contoller和@ResponseBody
 */

