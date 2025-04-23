package com.example.app.domain.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Getter
//@Setter
//@ToString
@Data
@AllArgsConstructor // 모든 인자를 받는 생성자
@NoArgsConstructor // 디폴트 생성자
@Component
@Builder
public class PersonDto {
	private String username;
	private int age;
	private String addr;
	
}
