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
public class DataSourceTests {

    @Autowired
    private DataSource dataSource;
    @Test
    public void t1() throws SQLException {
        System.out.println(dataSource);
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,?)");
        pstmt.setInt(1,222);
        pstmt.setString(2,"ababab");
        pstmt.setString(3,"springboot@test.com");
        pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        pstmt.executeUpdate();
    }
}
