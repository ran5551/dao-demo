package com.ran.dao;

import com.ran.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
    int addBook(Book book);

}
