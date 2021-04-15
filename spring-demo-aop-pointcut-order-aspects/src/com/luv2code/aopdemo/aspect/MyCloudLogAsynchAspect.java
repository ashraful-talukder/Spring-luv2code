package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyCloudLogAsynchAspect {

	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("===============>>> Logging to Cloud in async fashion\n");
	}
}
