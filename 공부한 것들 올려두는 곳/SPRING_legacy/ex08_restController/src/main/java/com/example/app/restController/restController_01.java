package com.example.app.restController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.controller.MemoController;
import com.example.app.domain.dto.MemoDto;

import lombok.extern.slf4j.Slf4j;

@RestController // Controller 처럼 페이지를 찾는것이 아니라 데이터를 반환한다.
@Slf4j
@RequestMapping("/rest")  // @RequestMapping은 **공통 경로(prefix)**를 붙이기 위한 것이다.
public class restController_01 {
	@GetMapping(value="/getText" ,produces=MediaType.TEXT_PLAIN_VALUE)
	public String f1() {
		log.info("GET /rest/getText...");
		return "Hello WORLD"; // 문자열 그대로 화면에 출력한다.
	} // @Controller 였다면 HELLO WORLD라는 뷰 파일을 띄울려고 하는구나~ 라고 해석한다. 그래서 /WEB-INF/views/Hello WORLD.jsp 이런 파일을 찾을려고 한다. -> ERROR
	
	@GetMapping(value="/getJson", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MemoDto f2() {
		log.info("GET /rest/getJson...");
		return new MemoDto(11,"ABCD","SSSS",LocalDateTime.now());
	}  // 만약 객체를 리턴하면? → 자동으로 JSON으로 변환돼서 브라우저에 뜬다. ({"key":"value"} 이런 식으로)


	@GetMapping(value="/getXml", produces=MediaType.APPLICATION_XML_VALUE)
	public MemoDto f3() {
		log.info("GET /rest/getXml...");
		return new MemoDto(11,"ABCD","AAAA",LocalDateTime.now());
	}
	
	@GetMapping(value="/getXmlList" , produces=MediaType.APPLICATION_XML_VALUE)
	public List<MemoDto> f4() {
		log.info("GET /rest/getXmlList...");
		List<MemoDto> list = new ArrayList();
		for(int i=0;i<50;i++) {
			list.add(new MemoDto(i,"A"+i,"aa",LocalDateTime.now()));
		}
		return list;
	}
	
	@GetMapping(value="/getXmlList2/{show}" , produces=MediaType.APPLICATION_XML_VALUE)
	public  ResponseEntity< List<MemoDto> > f5(@PathVariable("show") boolean show) {
		log.info("GET /rest/getXmlList2...");
		
		if(show) {
			List<MemoDto> list = new ArrayList();
			for(int i=0;i<50;i++) {
				list.add(new MemoDto(i,"A"+i,"",LocalDateTime.now()));
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}	
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);	
	}
	
}
