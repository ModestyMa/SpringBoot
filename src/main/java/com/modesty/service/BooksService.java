package com.modesty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.modesty.dao.BooksDao;
import com.modesty.pojo.po.Books;

/**
 * @author Modesty
 * @Version 2020年4月5日 下午8:19:01
 */

@Transactional
@Service
public class BooksService {
	@Autowired
	BooksDao booksDao;

	public void addBooks(Books books) {
		booksDao.save(books);
	}

	public List<Books> getBooksByAuthorName(String authorName){
		return booksDao.getBooksByAuthorName(authorName);
	}

	public List<Books> getBooksByBookName(String bookName){
		return  booksDao.getBooksByBookName(bookName);
	}

	public void updateAuthorByName(String author,String bookName){
		booksDao.updateAuthorByName(author, bookName);
	}
}


/**
 * Notes
 */
