package DbTests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.domain.dao.MemoDaoImpl;
import com.example.app.domain.dto.MemoDto;
import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;
import com.mysql.cj.xdevapi.PreparableStatement;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class DataSourceTests {

	
//	@Autowired
//	private DataSource dataSource1;
//	
//	@Autowired
//	private MemoDaoImpl memoDaoImpl;
//	
//	
//	@Autowired
//	private DataSource dataSource2;
//	
//	
//	@Autowired
//	private DataSource dataSource3;
//	
//	@Disabled
//	@Test
//	void test() throws SQLException {
//		System.out.println(dataSource1);
//		Connection con = dataSource1.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("insert into tbl_book values('abcd','abcd','abcd','abcd')");
//		pstmt.executeUpdate();
//	}
//	
//	
//	@Disabled
//	@Test
//	void test2() throws SQLException {
//		memoDaoImpl.insert(new MemoDto(1,"a","a",LocalDateTime.now(),null));
//	}
//	
//	@Disabled
//	@Test
//	void test3() throws Exception{
//		System.out.println(dataSource2);
//		Connection con = dataSource2.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("insert into tbl_book values('a3www','aaaa','aaaa','aaaa')");
//		pstmt.executeUpdate();
//	}
//	
//	@Test
//	void test4() throws Exception{
//		System.out.println(dataSource3);
//		Connection con = dataSource3.getConnection();
//		PreparedStatement pstmt = con.prepareStatement("insert into tbl_book values('kkkkk','kkkk','kkkk','kkkk')");
//		pstmt.executeUpdate();
//	}
	
	

}
