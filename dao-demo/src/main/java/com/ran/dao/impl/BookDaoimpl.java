package com.ran.dao.impl;

import com.ran.dao.BookDao;
import com.ran.entity.Book;
import com.ran.util.Dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoimpl implements BookDao {
    @Override
    public List<Book> findAll() {
        String sql = "select * from books";
        List<Book> books = new ArrayList<>();
        Connection conn = Dbutil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps =conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book().setId(rs.getInt("id"))
                        .setTitle(rs.getString("title"))
                        .setPrice(rs.getDouble("price"))
                        .setQuantity(rs.getInt("quantity"));
                books.add(book);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            Dbutil.close(conn, ps, rs);
        }
        return books;
    }
    @Override
    public int addBook(Book book) {
        String sql = "insert into books(title,price,quantity) values (?,?,?)";
        Connection connection = Dbutil.getConnection();
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(true);
            statement=connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setDouble(2,book.getPrice());
            statement.setInt(3,book.getQuantity());
            return statement.executeUpdate();
//            connection.setAutoComait(true);
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, book.getTitle());
//            ps.setDouble(2, book.getPrice());
//            ps.setInt(3, book.getQuantity());
//            return ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            Dbutil.close(connection, statement, null);
        }
    }
}
