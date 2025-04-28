package DiTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.app.config.PersonComponent;
import com.example.app.domain.dto.PersonDto;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
class DiTests {

	
	@Autowired
	private PersonDto personDto1;
	
	@Autowired
	private PersonDto personDto2;
	
	@Autowired
	private PersonDto person01; // bean명을 제대로 적어야한다.
	
	
	@Autowired
	private PersonDto personBean;
	
	
	@Autowired
	private PersonComponent personComponent; // bean명은 첫글자 소문자로 시작
	
	@Disabled
	@Test
	void test() {
		System.out.println(personDto2);
		System.out.println(person01);
		System.out.println(personBean);
		System.out.println(personComponent);
	}
	
	
	@Autowired
	private ApplicationContext applicationContext;
	@Test
	public void test2() {
		assertNotNull(applicationContext);
		System.out.println(applicationContext.getBean("personDto1"));
		System.out.println(applicationContext.getBean("personDto2"));
		
	}

}
