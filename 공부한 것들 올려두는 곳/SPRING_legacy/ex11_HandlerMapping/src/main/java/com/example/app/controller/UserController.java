package com.example.app.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.app.domain.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("UserController's dataBinder" +webDataBinder );
		webDataBinder.registerCustomEditor(String.class, "phone", new PhoneEditor());
		webDataBinder.registerCustomEditor(LocalDate.class, "birthday", new BirthdayEitor());
	}
	
	@GetMapping("/join")
	public void join() {
		log.info("GET /join");
	}
	
	@PostMapping("/join")
	public void join_post(@ModelAttribute @Valid UserDto dto ,BindingResult bindingResult, Model model) {
		log.info("POST /join" +dto);
		if(bindingResult.hasErrors()) {
			for(FieldError error : bindingResult.getFieldErrors()) {
				log.info("Error Field : " + error.getField()+" Error MSG : " + error.getDefaultMessage());
				model.addAttribute(error.getField(),error.getDefaultMessage()); // model.addAttribute("userid", "아이디는 필수입니다")
			}
		}
	}
	
	private static class PhoneEditor extends PropertyEditorSupport{

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			text = text.replaceAll("-", "");
			setValue(text);
		}
		
		
	}
	
	
	private static class BirthdayEitor extends PropertyEditorSupport{

		@Override
		public void setAsText(String dataTest) throws IllegalArgumentException {
			log.info("BirthdayEitor setAsText invoke..." + dataTest);
			
			LocalDate date = null;
			if(dataTest.isEmpty()) {
				date = LocalDate.now();
			}else {
				dataTest = dataTest.replaceAll("~", "-");
				date = LocalDate.parse(dataTest, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
			
			setValue(date);
		}
		
	}
	
}
