package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		CricketCoach theCoach2 = context.getBean("myCricketCoachAnother", CricketCoach.class);
		
		//call method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//call our new methods to get literal values
		System.out.println(theCoach.getEmail());
		
		System.out.println(theCoach.getTeam());
		
		//call our values from properties file
		System.out.println(theCoach2.getEmail());
		
		System.out.println(theCoach2.getTeam());
		
		//close the context
		context.close();
	}

}
