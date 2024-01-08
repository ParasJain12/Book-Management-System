package com.springbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.dao.BookDao;
import com.springbook.model.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> getAllBook() {
		return bookDao.findAll();
	}

	@Override
	public void save(Book book) {
		bookDao.save(book);
	}

	@Override
	public Book getById(Integer id) {
		Optional <Book> optional = bookDao.findById(id);
		Book book=null;
		if(optional.isPresent()) {
			book = optional.get();
		}else {
			throw new RuntimeException("Book not found for id :" + id);
		}
		return book;
	}

	@Override
	public void deleteViaId(int id) {
		bookDao.deleteById(id);
	}
	
}
