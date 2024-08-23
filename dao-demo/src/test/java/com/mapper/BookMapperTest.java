package com.mapper;

import com.ran.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class BookMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession session;

    @BeforeClass
    public static void setUpBeforeClass(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // Set static variable
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setUp(){
        session = sqlSessionFactory.openSession();
    }

    @After
    public void tearDown(){
        if (session != null) {
            session.close();
        }
    }

    @Test
    public void findAll() {
        BookMapper bookMapper = session.getMapper(BookMapper.class);
        bookMapper.findAll().forEach(System.out::println);
    }

    @Test
    public void addBook() {
        BookMapper bookMapper = session.getMapper(BookMapper.class);
        int result= bookMapper.addBook(new Book().setTitle("book1").setPrice(100));
        session.commit();
        assertEquals(1,result);
//        Book book = new Book();
//        book.setTitle("book1");
//        book.setPrice(100);
//        int result = bookMapper.addBook(book);
//        assertEquals(1, result);
    }

    @Test
    public void updateBook() {
        BookMapper bookMapper=session.getMapper(BookMapper.class);
        int result=bookMapper.updateBook(new Book().setId(2).setTitle("book222").setPrice(200));
        session.commit();
        assertEquals(1,result);
    }

    @Test
    public void deleteBook() {
        BookMapper bookMapper=session.getMapper(BookMapper.class);
        int rs=bookMapper.deleteBook(1);
        assertEquals(1,rs);
        session.commit();
    }
}
