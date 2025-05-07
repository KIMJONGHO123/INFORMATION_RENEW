package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
@Slf4j
@RequestMapping("/except")
public class ExceptionTestController {
	
//	@ExceptionHandler(FileNotFoundException.class)
//	public String fileNotFountExceptionHandler(Exception e, Model model) {
//
//		log.error("error : " + e);
//
//		return "except/error";
//	}
//	
//	@ExceptionHandler(ArithmeticException.class)
//	public String ArithmeticException(Exception e, Model model) {
//		// 50/0 과 같이 0으로 나눴을때의 에러를 처리하는 함수
//		log.error("error : " + e);
//		
//		return "except/error";
//	}
	
//	@ExceptionHandler(Exception.class)
//	public String Exception(Exception e, Model model) {
//		// 50/0 과 같이 0으로 나눴을때의 에러를 처리하는 함수
//		log.error("error : " + e);
//		
//		return "except/error";
//	}
	
	@GetMapping("/ex")
	public void ex1_1(Exception e, Model model) throws FileNotFoundException {
		// 50/0 과 같이 0으로 나눴을때의 에러를 처리하는 함수
		log.error("error : " + e);
		
		throw new FileNotFoundException("파일을 찾을수가 없습니다.");
	}
	
	@GetMapping("/page01")
	public void ex1() throws FileNotFoundException   {
		log.info("GET /exTest/ex1");
		throw new FileNotFoundException("파일을 찾을 수가 없습니다.");
	}
	
	
	@GetMapping("/page02/{num}/{div}")
	public String ex2(
			@PathVariable("num") int num,
			@PathVariable("div") int div,
			Model model
			) throws ArithmeticException   {
		log.info("GET /exTest/ex2"+(num/div));
		model.addAttribute("result",(num/div));
		return "except/page02";
	}
}
