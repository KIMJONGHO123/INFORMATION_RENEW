package com.example.app.controller;

import java.beans.PropertyEditorSupport;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.taglibs.authz.AuthenticationTag;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.config.auth.PrincipalDetails;
import com.example.app.domain.dto.UserDto;
import com.example.app.domain.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("UserController's dataBinder" +webDataBinder );
		webDataBinder.registerCustomEditor(String.class, "phone", new PhoneEditor());
		webDataBinder.registerCustomEditor(LocalDate.class, "birthday", new BirthdayEditor());
	}
	
	@GetMapping("/login")
	public void login() {
		log.info("GET /login...");
	}
	
//	@GetMapping("/user")
//	public void user(Authentication authentication) {
//		log.info("GET/ user..."+authentication);
//		log.info("name..."+authentication.getName());
//		log.info("principal"+authentication.getPrincipal());
//		log.info("authorities..."+authentication.getAuthorities());
//		log.info("details"+authentication.getDetails());
//		log.info("credential"+authentication.getCredentials());
//	}
	
	// 2번째 방법
//	@GetMapping("/user")
//	public void user(@AuthenticationPrincipal Principal principal ) {
//		log.info("GET/ user..."+principal);
//		
//	}
	
	@GetMapping("/user")
	public void user(@AuthenticationPrincipal Principal principal ,Model model) {
		log.info("GET/ user..."+principal);
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		log.info("authentication : " + authentication);
		
		model.addAttribute("auth",authentication);
		
	}
	@GetMapping("/manager")
	public void manager() 
	{
		log.info("GET/ manager...");	
	}
	@GetMapping("/admin")
	public void admin() {
	
		log.info("GET/ admin...");
	}
	
	@GetMapping("/join")
	public void join() {
		log.info("GET /join");
	}
	
	@PostMapping("/join")
	public String join_post(@ModelAttribute @Valid UserDto dto ,BindingResult bindingResult, Model model,RedirectAttributes redirectAttributes) {
		log.info("POST /join" +dto);
		for(FieldError error : bindingResult.getFieldErrors()) {
			log.info("Error Field : " + error.getField()+" Error MSG : " + error.getDefaultMessage());
			model.addAttribute(error.getField(),error.getDefaultMessage()); // model.addAttribute("userid", "아이디는 필수입니다")
			return "join";
		}
		boolean isJoin = userServiceImpl.userJoin(dto);
		if(isJoin) {
			redirectAttributes.addFlashAttribute("message","회원가입 완료!");
			return "redirect:/login";
		}else {
			return "join";
		}
	
		
	}
	
	private static class PhoneEditor extends PropertyEditorSupport{

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			text = text.replaceAll("-", "");
			setValue(text);
		}
		
		
	}
	
	
	private static class BirthdayEditor  extends PropertyEditorSupport{

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
