package com.example.demo.controller;


import com.example.demo.domain.dto.MemoDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {
	
	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("MemoController's dataBinder" +webDataBinder );
		webDataBinder.registerCustomEditor(LocalDate.class, "dateTest", new DateTestEditor());
	}
	
	
	@GetMapping("/add")
	public void add_get() {
		log.info("GET /memo/add...");
		
	}
	
	@PostMapping("/add")
	public void add_post(@Valid MemoDto dto, BindingResult bindingResult, Model model) { //@ModelAttribute 생략되어있는 거다.
		log.info("POST /memo/add..."+ dto);
		if(bindingResult.hasErrors()) {
			//log.info("유효성 에러발생" + bindingResult.getFieldError("id").getDefaultMessage());
			for(FieldError error : bindingResult.getFieldErrors()) {
				log.info("Error Field : " + error.getField()+" Error MSG : " + error.getDefaultMessage());
				model.addAttribute(error.getField(),error.getDefaultMessage());
			}
			
		}
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
