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
	
	// create point-cut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create point-cut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create point: include package..exclude getter/setter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void forDAOPackageNoGetterSetter() {}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n===============>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void performAPIAnalytics() {
		System.out.println("===============>>> Performing API analytics\n");
	}
}
