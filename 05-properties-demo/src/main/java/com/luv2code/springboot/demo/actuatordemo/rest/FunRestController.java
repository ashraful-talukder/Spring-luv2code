package com.luv2code.springboot.demo.actuatordemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// inject properties for: cacho.name and team.name 
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	// expose new end-point for "team-info"
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "coach name: " + coachName + "\r\nTeam Name: " + teamName;
	}
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World!";
	}
	
	@GetMapping("/workout")
	public String getWorkout() {
		return "run hard 5k!";
	}
	
	@GetMapping("fortune")
	public String getFortune() {
		return "today is your lucky day!";
	}

}
