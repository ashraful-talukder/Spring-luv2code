package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.luv2code.aopdemo.Account;

@Aspect
@Order(5)
@Component
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>> Executing @Around on method: " + method);
		
		// get begin time stamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		// get end time stamp
		long end = System.currentTimeMillis();
		
		// compute the duration and display it
		long duration = end - begin;
		myLogger.info("=====>>> Duration : " + duration / 1000.0 + "seconds");
		
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=========>>> Executing @After(finally) on method: " + method);
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
					throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=========>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		myLogger.info("\n=========>>> The exception is: " + theExc);
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,
													List<Account> result) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=========>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of method call
		myLogger.info("\n=========>>> result is: " + result);
		
		// let's post-process the data .. let's modify it
		
		// convert the account name to upper-case
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n=========>>> result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		for(Account tempAccount: result) {
			
			// get the upper-case version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
		}
		
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("===============>>> Executing @Before advice on addAccount()\n");
		
		// display the method signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + theMethodSignature);
		
		// display the method arguments
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through the arguments
		for(Object tempArg: args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}
	}
}
