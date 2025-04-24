package com.example.app.controller;


import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.dto.MemoDto;
import com.example.app.domain.service.MemoServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {
	
	@Autowired
	private MemoServiceImpl memoServiceImpl;
	
//	@InitBinder
//	public void dataBinder(WebDataBinder webDataBinder) {
//		log.info("MemoController's dataBinder" +webDataBinder );
//		webDataBinder.registerCustomEditor(LocalDate.class, "dateTest", new DateTestEditor());
//	}
	
	@GetMapping("/ex")
	public String Exception(Exception e, Model model) {
		// 50/0 과 같이 0으로 나눴을때의 에러를 처리하는 함수
		log.error("error : " + e);
		
		return "except/error";
	}
	
	
	@GetMapping("/add")
	public void add_get() {
		log.info("GET /memo/add...");
		
	}
	
	@PostMapping("/add")
	public void add_post(@Valid MemoDto dto, BindingResult bindingResult, Model model) throws Exception { //@ModelAttribute 생략되어있는 거다.
		log.info("POST /memo/add..."+ dto);
		// 유효성 실패시
		if(bindingResult.hasErrors()) {
			//log.info("유효성 에러발생" + bindingResult.getFieldError("id").getDefaultMessage());
			for(FieldError error : bindingResult.getFieldErrors()) {
				log.info("Error Field : " + error.getField()+" Error MSG : " + error.getDefaultMessage());
				model.addAttribute(error.getField(),error.getDefaultMessage());
			}
			return;
			
		}
		 
		// 유효성 성공시
		// 서비스
		boolean isAdded = memoServiceImpl.registrationMemo(dto);
		
	}
	
	
	// static private 
	
	private static class DateTestEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String dataTest) throws IllegalArgumentException {
			log.info("DataTestEiditor's setAsText invoke..." + dataTest);
			
			LocalDate date= null;
			if(dataTest.isEmpty()) {
				//dataTest = LocalDate.now().toString();
				 date = LocalDate.now();
				
			}else {
				//yyyy#MM#dd -> yyyy-MM-dd
				dataTest= dataTest.replaceAll("#","-");
				date = LocalDate.parse(dataTest,DateTimeFormatter.ofPattern("yyyy-MM-dd"));

				
			}
			
			setValue(date);
		}

	}
	
	

}
