package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.app.domain.dto.PersonDto;

@Configuration // @Configuration 붙이면 bean이 된다
public class PersonDtoBeanConfig {
	
	@Bean
	public PersonDto person03() {
		return PersonDto.builder()
				.age(55)
				.username("철수")
				.addr("울산")
				.build();
	}
	
	@Bean
	public PersonDto person01() {
		
		return new PersonDto("김범수", 44,"서울");
	}
	
	@Bean(name = "personBean") // 이름 설정따로하기
	public PersonDto person04() {
		
		return new PersonDto("박강원", 34,"대전");
	}
}
