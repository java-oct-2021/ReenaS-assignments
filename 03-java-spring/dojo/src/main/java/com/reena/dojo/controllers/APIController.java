package com.reena.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reena.dojo.models.Student;
import com.reena.dojo.services.StudentService;

@RestController
public class APIController {
	@Autowired
	private StudentService sService;
	
	@GetMapping("/api/students")
	public List<Student> getStudents(){
		return sService.allStudents();
	}
	@PostMapping("/api/create")
	public Student create(Student newStudent){
		return sService.createStudent(newStudent);
	}
	@DeleteMapping("api/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.sService.deleteStudent(id);
		return "Student is deleted";
	}
	

		
}
