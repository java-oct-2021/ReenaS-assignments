package com.user.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.user.project.models.Project;
import com.user.project.models.User;
import com.user.project.services.ProjectService;
import com.user.project.services.UserService;
import com.user.project.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private  UserService userService;
	
	@Autowired
	private  UserValidator validators;
		
	@Autowired
	private ProjectService pService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	@PostMapping("/registration")
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
		// Email/password validation 
		validators.validate(user, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		} 
		else {
			User newUser=userService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/projects";

		}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    }
	
	@PostMapping("/login") 
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	        // if the user is authenticated, save their user id in session
		if(userService.authenticateUser(email, password)) {
			User user=userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/projects";
			
			
		}
	        // else, add error messages and return the login page
		 redirectAttributes.addFlashAttribute("error", "Invaild Email/Pass!!!");
		 return "redirect:/";
		
	    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
		session.invalidate();
        // redirect to login page
		return "redirect:/";
		
    }
	 
//	 **********************Project Routes************************* 

	// Project Dashboard
		@GetMapping("/projects")
		public String projects(Model model, HttpSession session) {
			if (session.getAttribute("userId") != null) {
				List<Project> projects = this.pService.allProjects();
//				Get user from session 
				User user = userService.findUserById((Long) session.getAttribute("userId"));
				model.addAttribute("projects", projects);
				model.addAttribute("user", user);
				return "projects.jsp";
			}
			return "redirect:/";
		}

		// New Project Page
		@GetMapping("/projects/new")
		public String index(@ModelAttribute("newProject") Project project) {
			//Get User from session and pass it in model
			return "new.jsp";
		}
		// Create Project
		@PostMapping("/projects/create")
		public String create(@Valid @ModelAttribute("newProject") Project project, BindingResult result) {
			if (result.hasErrors()) {
				return "new.jsp";
			} else {
				
				Project newProject = pService.createProject(project);
				return "redirect:/projects";
			}
			
		}
		
		// Get One project details
				@GetMapping("/projects/project/{id}")
				public String project(@PathVariable("id") Long projectId, Model model, HttpSession session) {
					Project project = pService.getOneProject(projectId);
					model.addAttribute("project", project);
					model.addAttribute("userLoggedIn",(Long)session.getAttribute("userId"));
					return "project.jsp";
				}


		// Delete Project
		@GetMapping("/projects/delete/{id}")
		private String deleteProject(@PathVariable("id") Long id) {
			pService.deleteProject(id);
			return "redirect:/projects";
		}

		// Edit- Page
		@GetMapping("/projects/edit/{id}")
		public String edit(@PathVariable("id") Long id, @ModelAttribute("editedProject") Project project, Model model,
				HttpSession session) {
			Project editProject = pService.getOneProject(id);
			model.addAttribute("editProject", editProject);
			return "edit.jsp";
		}

		// Update project
		@PostMapping("/projects/update/{id}")
		public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("editedProject") Project project,
				BindingResult result, Model model) {
			if (result.hasErrors()) {
				Project editProject = pService.getOneProject(id);
				model.addAttribute("editProject", editProject);
				return "edit.jsp";
			} else {
				Project newProject = pService.updateProject(id, project.getProjectName(), project.getDescription());
				return "redirect:/projects";

			}
		}

		
		// Like Project
		@GetMapping("/projects/like/{projectId}")
		public String Like(@PathVariable("projectId") Long projectId, HttpSession session) {
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.findUserById(userId);
			Project project = pService.getOneProject(projectId);
			pService.likeProject(project, user);
			return "redirect:/projects";
		}
		// Unlike Project
		@GetMapping("/projects/unLike/{projectId}")
		public String unLike(@PathVariable("projectId") Long projectId, HttpSession session) {
			//Unlike Project- logic
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.findUserById(userId);
			Project project = pService.getOneProject(projectId);
			pService.unLikeProject(project, user);
			return "redirect:/projects";
		}

	
}
