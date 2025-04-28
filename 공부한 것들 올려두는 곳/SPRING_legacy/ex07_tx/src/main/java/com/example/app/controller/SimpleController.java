package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/test")
public class SimpleController {
	
	@GetMapping("/ex")
	public String Exception(Exception e, Model model) {
		// 50/0 과 같이 0으로 나눴을때의 에러를 처리하는 함수
		log.error("error : " + e);
		
		return "except/error";
	}
	
	@RequestMapping(value= "/test1", method = RequestMethod.GET) // GET 요청에 대한 반응
	public void test1() {
		log.info("GET /test/test1...");
		
		//파라미터
		// 유효성
		// 서비스
		// 뷰이동(x) 리졸브가 해결해준다.
	}
	
	@RequestMapping(value= "/test2", method = RequestMethod.GET) // GET 요청에 대한 반응
	public String test2() {
		log.info("GET /test/test2...");
		
		return "test/abcd";
	}
	
	
	@RequestMapping(value= "/test3", method = {RequestMethod.GET,RequestMethod.POST}) // GET과 POST 요청에 대한 반응
	public void test3() {
		log.info("GET /test/test3...");
		
	}
	
}
