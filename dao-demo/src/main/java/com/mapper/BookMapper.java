package com.mapper;

import com.ran.entity.Book;

import java.util.List;

public interface BookMapper {
    List<Book> findAll();
    int addBook(Book book);
    int updateBook(Book book);
    int deleteBook(int id);
}
