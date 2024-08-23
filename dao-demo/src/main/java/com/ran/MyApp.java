package com.ran;

import com.mapper.BookMapper;
import com.ran.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws Exception {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        BookMapper bookMapper=session.getMapper(BookMapper.class);
        List<Book> books = bookMapper.findAll();
//        for (Book book : books){
//            System.out.println(book);
//        }
        books.forEach(System.out::println);

        session.close();
    }
}
