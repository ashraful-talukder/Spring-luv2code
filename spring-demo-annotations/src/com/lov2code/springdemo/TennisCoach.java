package com.lov2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*if we don't use any name inside of the component then to get bean 
we have to use the class name and we have to keep in mind that the 
first letter of the class name should be in small letter*/

@Component("thatSillyCoach")
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
