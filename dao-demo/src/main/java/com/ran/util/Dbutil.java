package com.ran.util;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.sql.*;

public class Dbutil {
    private static final String url="jdbc:mysql://47.96.117.148:3306/test";
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String username="root";
    private static final String password="123";
    public static Connection getConnection(){
        Connection conn=null;
        BasicDataSource dataSource =new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(30);
        dataSource.setMinIdle(500);
        dataSource.setMaxIdle(1000);
        dataSource.setMaxWait(1000);

        try {
            conn=dataSource.getConnection();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

//        try {
//            Class.forName(driver);
//            conn =DriverManager.getConnection(url, username, password);
//        }catch (ClassNotFoundException e){
//            throw new RuntimeException(e);
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
        return conn;
    }

    public static void close(Connection conn, PreparedStatement statement, ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        try {
            if (statement != null){
                statement.close();
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
        try {
            if (conn != null){
                conn.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
