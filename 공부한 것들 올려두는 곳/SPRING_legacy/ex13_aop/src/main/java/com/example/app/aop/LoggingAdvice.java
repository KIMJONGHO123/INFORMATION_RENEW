package com.example.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {
	
	
	@Before("execution(boolean com.example.app.domain.service.MemoServiceImpl.registrationMemo(..))")
	public void loggingBefore(JoinPoint joinPoint) {
		log.info("[AOP] Befor..." + joinPoint);
	}
	
	@After("execution(* com.example.app.domain.service.MemoServiceImpl.getAllMemo())")
	public void loggingAfter(JoinPoint joinPoint) {
		log.info("[AOP] After..." + joinPoint);
		log.info("[AOP] After..." + joinPoint.getTarget());
		log.info("[AOP] After..." + joinPoint.getSignature());
		log.info("[AOP] After..." + joinPoint.getSignature().getName());
		
	}
	
	@Around("execution(* com.example.app.domain.service.*.*(..))")
	public Object logginAround(ProceedingJoinPoint pjp) throws Throwable	{
		// 이전 시점
		log.info("[AOP] AROUND BEFORE");
		long startTime = System.currentTimeMillis();
		// MVC 흐름대로 진행
		Object isUpdated = (Object)pjp.proceed();
		// 이후 시점
		log.info("[AOP] AROUND AFTER");
		long endTime = System.currentTimeMillis();
		log.info("[AOP] TIME : " + (endTime-startTime)+ " ms");
		
		
		return null;
	}
	
	
}
