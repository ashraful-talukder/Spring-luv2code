package com.lov2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*if we don't use any name inside of the component then to get bean 
we have to use the class name and we have to keep in mind that the 
first letter of the class name should be in small letter*/

@Component
/*@Scope("prototype")*/
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	/*// we will use the following declaration in the case of method/constructor/method injection
	private FortuneService fortuneService;*/
	
	//default constructor
	public TennisCoach() {
		System.out.println(">> inside default constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStrartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStrartupStuff");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff");
	}
	
	/*// constructor injection for dependency injection
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/
	
	/*// define a setter method for dependency injection
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> inside setter method");
		fortuneService = theFortuneService;
	}*/
	
	/*// method injection for dependency injection
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomeCrazyStuff method");
		fortuneService = theFortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
