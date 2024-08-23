package com.ran.dao.impl;

import com.ran.dao.BookDao;
import com.ran.entity.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BookDaoimplTest {

    private BookDao bookDao = new BookDaoimpl();
    @Test
    public void findAll() {
        List<Book> books = bookDao.findAll();
        books.forEach(System.out::println);
        Assert.assertTrue(books.size() >0);
    }

    @Test
    public void addBook() {
        int i = bookDao.addBook(new Book().setTitle("Java123").setPrice(10.5).setQuantity(100));
        Assert.assertTrue(i ==1);
    }

}