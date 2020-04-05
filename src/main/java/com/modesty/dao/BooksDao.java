package com.modesty.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.modesty.pojo.po.Books;

/**
* @author Modesty
* @Version 2020年4月5日 下午7:46:12
*/

public interface BooksDao extends JpaRepository<Books, Integer>{
	
	@Query("select b from books b where b.author=:authorName")
	List<Books> getBooksByAuthorName(String authorName);
	
	@Query(value = "select * from books b where b.name like %?1% ",nativeQuery = true)
	List<Books> getBooksByBookName(String bookName);
	
	@Modifying
	@Query(value = "update books b set b.name = ?2 where b.author = ?1 ",nativeQuery = true)
	void updateAuthorByName(String author,String bookName);
}


/**
* Notes
* 若涉及修改操作则家@Modifying
*/
