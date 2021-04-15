package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// declaration of point-cut
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n===============>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDAOPackage()")
	public void performAPIAnalytics() {
		System.out.println("===============>>> Performing API analytics\n");
	}
}
