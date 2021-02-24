package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//add new fields for email and team
	private String email;
	private String team;
	
	//create no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constuctor");
	}

	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method");
		this.fortuneService = fortuneService;
	}	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("CricketCoach: inside setter method - set Email address");
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - set team name");
		this.team = team;
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
