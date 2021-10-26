package com.reena.dojo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	
	
	
	
	
	
	
	



}
