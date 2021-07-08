package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data .. only once!
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Ashraful", "Talukder"));
		theStudents.add(new Student("Ashraful", "Alam"));
		theStudents.add(new Student("Chayan", "Mistry"));
		theStudents.add(new Student("Litan", "Sarkar"));
	}
	
	// define end-point for "/students" -return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		
		
		return theStudents;
	}
	
	// define end-point for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// just index into the list ... keep it simple for now
		return theStudents.get(studentId);
	}
}
