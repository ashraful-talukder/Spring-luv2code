package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//create no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constuctor");
	}

	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice fast bowling for 15 min";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
