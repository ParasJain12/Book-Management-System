package com.springbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbook.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book,Integer> {

}