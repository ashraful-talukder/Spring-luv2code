package com.lov2code.springdemo;

import org.springframework.stereotype.Component;

/*if we don't use any name inside of the component then to get bean 
we have to use the class name and we have to keep in mind that the 
first letter of the class name should be in small letter*/

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
