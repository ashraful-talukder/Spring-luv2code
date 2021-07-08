package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define end-point for "/students" -return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Ashraful", "Talukder"));
		theStudents.add(new Student("Ashraful", "Alam"));
		theStudents.add(new Student("Chayan", "Mistry"));
		theStudents.add(new Student("Litan", "Sarkar"));
		
		return theStudents;
	}
}
