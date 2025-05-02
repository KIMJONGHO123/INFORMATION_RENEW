package com.example.demo.config;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@SpringBootTest
class DataSourceConfigTest {
    @Autowired
    private DataSource dataSource2;

    @Autowired
    private DataSource dataSource3;

    @Test
    public void t1() throws SQLException {
        Connection conn = dataSource2.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,?)");
        pstmt.setInt(1,333);
        pstmt.setString(2,"ababab");
        pstmt.setString(3,"springboot@test.com");
        pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        pstmt.executeUpdate();
    }

    @Test
    public void t2() throws SQLException {
        Connection conn = dataSource3.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,?)");
        pstmt.setInt(1,444);
        pstmt.setString(2,"ababab");
        pstmt.setString(3,"springboot@test.com");
        pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        pstmt.executeUpdate();
    }
}