package com.luv2code.springboot.demo.actuatordemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello World!";
	}
	
	@GetMapping("/ash")
	public String helloAsh() {
		return "Ashraful is the boss!";
	}

}