package com.reena.dojo.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reena.dojo.models.Project;
import com.reena.dojo.models.Student;
import com.reena.dojo.services.ProjectService;
import com.reena.dojo.services.StudentService;

@Controller
public class ProjectController {
	@Autowired
	private StudentService sService;
	
	@Autowired
	private ProjectService pService;
	
//	List All Projects 
	@GetMapping("/projects")
	public String allProjects(Model model) {
		List<Project> allProjects=pService.allProjects();
		model.addAttribute("allProjects",allProjects);
		return "/projects/projects.jsp";
	}
	
//Create a new project 
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("newProject") Project project, Model model) 	{
	List<Student> allStudents=this.sService.allStudents();
		model.addAttribute("allStudents",allStudents);
		return "/projects/new.jsp";
	}
	
	@PostMapping("/projects/create")
	public String create(@ModelAttribute("newProject") Project project) {
		this.pService.createProject(project);
		return "redirect:/projects";
		
		
	}

//	Login
	@GetMapping("/projects/login/{id}")
	public String login(@PathVariable("id") Long id, HttpSession session ) {
		session.setAttribute("userId", id);
		return "redirect:/projects"; 
	}
		
	
//  Like
	@GetMapping("/projects/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession mysession) {
		// How do I like a project? 	
		Long studentId=(Long)mysession.getAttribute("userId");
		Student student=sService.findStudent(studentId);
		Project project=pService.findProject(id);
		pService.AddLikes(project, student);
		return "redirect:/projects"; 
	}

}
