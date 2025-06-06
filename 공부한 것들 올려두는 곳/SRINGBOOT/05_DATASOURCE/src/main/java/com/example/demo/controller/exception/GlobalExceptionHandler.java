package com.example.demo.controller.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler { // controller내의 모든 클래스에서 발생하는 예외를 받는 클래스
	
	@ExceptionHandler(Exception.class)
	public String AllExceptionExceptionHandler(Exception e, Model model) {
		log.info("GlobalExceptionHandler's error" + e);
		model.addAttribute("ex", e);
		return "global_error";
	}
	
}
