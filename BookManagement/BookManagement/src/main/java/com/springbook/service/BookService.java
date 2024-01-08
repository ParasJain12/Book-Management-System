package com.springbook.service;

import java.util.List;

import com.springbook.model.Book;

public interface BookService {
	List<Book> getAllBook();

	void save(Book book);

	Book getById(Integer id);

	void deleteViaId(int id);
}
