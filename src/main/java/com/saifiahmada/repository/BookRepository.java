package com.saifiahmada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

}
