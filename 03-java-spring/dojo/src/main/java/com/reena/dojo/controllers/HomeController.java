package com.reena.dojo.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reena.dojo.models.Student;
import com.reena.dojo.services.StudentService;

@Controller
public class HomeController {
	@Autowired
	private StudentService sService;

//	@RequestMapping("/")
	@GetMapping("/")
	public String index(@ModelAttribute("newStudent") Student student) {
			return "index.jsp";
	}
//	CRUD
//	Create student
	//Create student 
		@PostMapping("/create")
		public String create(@Valid @ModelAttribute("newStudent") Student student, BindingResult result) {
			if(result.hasErrors()) {
				return "index.jsp";
			} 
			else { 
			Student newStudent= sService.createStudent(student);
			return "redirect:/dash";
			}
			
		}
// 	List all students 
	@GetMapping("/dash")
	public String dash(Model model) {
		List<Student> allStudents= this.sService.allStudents();
		model.addAttribute("allStudents",allStudents);
		return "dash.jsp";
	}
	
// 	Delete a student
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.sService.deleteStudent(id);
		return "redirect:/dash";
	}
	
//	 Edit a student info
	  @GetMapping("/edit/{id}")
		public String edit(@PathVariable("id") Long id, @ModelAttribute("editedStudent") Student student, Model model) {
		  Student editStudent=sService.findStudent(id);
		  model.addAttribute("editStudent",editStudent);
		  return "edit.jsp";
		}
	  
	  //Update student Info
	  @PutMapping("/update/{id}")
	  public String update(@PathVariable("id") Long id,@Valid @ModelAttribute("editedStudent") Student student, BindingResult result) {
		  if(result.hasErrors()) {
				return "edit.jsp";
			} 
			else { 
			Student newStudent= sService.updateStudent(id, student.getFirstName(), student.getLastName(), student.getEmail());
			return "redirect:/dash";
			}
	  }
//	@RequestMapping("/result")
//	@RequestMapping(path="/result", method=RequestMethod.POST)
	@PostMapping("/result")
	public String result(@RequestParam("firstName") String fName,
			@RequestParam("email") String email,
			@RequestParam("lastName") String lastName, 
			Model model,
			HttpSession mysession) {
		model.addAttribute("firstName",fName);
		model.addAttribute("email",email);
		model.addAttribute("lastName",lastName);
		mysession.setAttribute("firstName",fName);
	
		
		return "result.jsp";
	}
	@GetMapping("/studentinfo")
	public String studentinfo() {
		return "studentinfo.jsp";
	}

}
