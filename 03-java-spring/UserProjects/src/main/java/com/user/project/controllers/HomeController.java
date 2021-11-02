package com.user.project.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.user.project.models.User;
import com.user.project.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private  UserService userService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	@PostMapping("/registration")
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
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
	 
	 
	@GetMapping("/projects")
	public String projects() {
		return "projects.jsp";
	}
	
}
