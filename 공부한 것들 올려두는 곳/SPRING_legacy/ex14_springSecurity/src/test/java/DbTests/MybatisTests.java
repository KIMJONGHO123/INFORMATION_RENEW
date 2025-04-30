//package DbTests;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.print.DocFlavor.STRING;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.example.app.domain.dto.MemoDto;
//import com.example.app.domain.dto.UserDto;
//import com.example.app.domain.mapper.MemoMapper;
//import com.example.app.domain.mapper.UserMapper;
//
//import lombok.Builder;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//class MybatisTests {
//
//	@Autowired
//	private SqlSessionFactory sqlSessionFactory;
//	
//	@Autowired
//	private UserMapper userMapper;
//
//	
//	
////	@Test	
////	public void user_test() {
////		UserDto dto1 = UserDto.builder()
////				.userid("abab")
////				.username("홍길동")
////				.password("1234")
////				.build();
////		UserDto dto2 = UserDto.builder()
////				.userid("cdcd")
////				.username("남길동")
////				.password("1234")
////				.build();		
//		
////		userMapper.insert(dto1);
////		userMapper.insert(dto2);
////		dto1.setAddr1("대구");
////		userMapper.update(dto1);
////		userMapper.delete("cdcd");
////		
////		System.out.println(userMapper.selectAt(dto1.getUserid()));
////		
////		List<UserDto> list1 = userMapper.selectAll();
////		list1.forEach(System.out::println);
////		
//		List<Map<String,Object>>list2 =  userMapper.selectAllResultMapXml();	
//		list2.forEach(System.out::println);
//		
//	}
//	
////	@Autowired
////	private MemoMapper memoMapper; // 이게 있어야 함
////
////	@Test
////	void t3() {
////		Map<String,Object> param = new HashMap();
////		param.put("type", "id");
////		param.put("keyword", "5");
////		
////		//List<Map<String,Object>> response = memoMapper.Select_if_xml(param);
////		//response.forEach(System.out::println);
////		
////		List<Map<String,Object>> response = memoMapper.Select_when_xml(param);
////		response.forEach(System.out::println);
////		
////	}
//
//}
//
