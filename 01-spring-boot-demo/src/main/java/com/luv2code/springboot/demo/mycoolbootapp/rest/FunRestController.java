package com.luv2code.springboot.demo.mycoolbootapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that return "Hello World!"
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! \nTime on server is " + LocalDateTime.now();
	}

}
