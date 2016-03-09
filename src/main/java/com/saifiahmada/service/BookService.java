package com.saifiahmada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saifiahmada.entity.Book;
import com.saifiahmada.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public void save(Book book) {
		bookRepository.save(book);
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}

}
