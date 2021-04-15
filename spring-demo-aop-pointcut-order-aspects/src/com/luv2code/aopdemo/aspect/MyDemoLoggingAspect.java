package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(5)
@Component
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("===============>>> Executing @Before advice on addAccount()\n");
	}
}
