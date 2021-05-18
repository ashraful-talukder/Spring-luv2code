package com.luv2code.aopdemo.aspect;

import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
					throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=========>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n=========>>> The exception is: " + theExc);
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
					returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,
													List<Account> result) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=========>>> Executing @AfterReturning on method: " + method);
		m
		// print out the results of method call
		System.out.println("\n=========>>> result is: " + result);
		
		// let's post-process the data .. let's modify it
		
		// convert the account name to upper-case
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n=========>>> result is: " + result);
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
		System.out.println("===============>>> Executing @Before advice on addAccount()\n");
		
		// display the method signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + theMethodSignature);
		
		// display the method arguments
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through the arguments
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}
}
