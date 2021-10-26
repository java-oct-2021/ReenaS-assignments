package com.reena.dojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reena.dojo.models.Student;
import com.reena.dojo.repositories.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository sRepo;

	public StudentService(StudentRepository sRepo) {
		this.sRepo = sRepo;
	}
	//List all students	
	public List<Student> allStudents(){
		return (List<Student>) sRepo.findAll();
	}
	//Create Student	
	public Student createStudent(Student newStudent) {
		return this.sRepo.save(newStudent);
		
	}
	//Delete Student
	public void deleteStudent(Long id) {
		this.sRepo.deleteById(id);
		
	}
	
	//One Student Detail	
		public Student findStudent(Long id) {
			return sRepo.findById(id).orElse(null);
		}

	// Update Student	
		public Student updateStudent(Long id, String firstName, String lastName, String email) {
			//query for student 
			Student student=findStudent(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setEmail(email);
			return sRepo.save(student);
			
		}
}
