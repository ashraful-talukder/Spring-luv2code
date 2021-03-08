package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

	// need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String displayTheFrom() {
		return "silly";
	}
}
