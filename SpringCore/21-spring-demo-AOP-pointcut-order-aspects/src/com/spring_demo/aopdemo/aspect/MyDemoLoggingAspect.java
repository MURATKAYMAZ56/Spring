package com.spring_demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// let's start with an @Before advice
	

	
	@Before("com.spring_demo.aopdemo.aspect.AllAopExpresions.forDaoPackageNoGetterSeter()")
	public void beforeAddAccountAdvice() {

		System.out.println("\n ====>>>>Executing @Before advice on addAccount()");
	}

	
	

}
