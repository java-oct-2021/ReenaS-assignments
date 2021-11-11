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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.user.project.models.Album;
import com.user.project.models.Rating;
import com.user.project.models.User;
import com.user.project.services.AlbumService;
import com.user.project.services.UserService;
import com.user.project.validators.UserValidator;



@Controller
public class HomeController {
	@Autowired
	private  UserService userService;
	
	@Autowired
	private  UserValidator validators;
	
	
	
	
	@Autowired
	private AlbumService aService;
	
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
			return "redirect:/Albums";

		}
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    }
	
	@PostMapping("/login") 
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	        // if the user is authenticated, save their user id in session
		if(userService.authenticateUser(email, password)) {
			User user=userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/albums";
			
			
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
	 
//	 **********************Album Routes************************* 

	// Album Dashboard
		@GetMapping("/albums")
		public String Albums(Model model, HttpSession session) {
			if (session.getAttribute("userId") != null) {
				List<Album> albums = this.aService.allAlbums();
//				Get user from session 
				User user = userService.findUserById((Long) session.getAttribute("userId"));
				model.addAttribute("albums", albums);
				model.addAttribute("user", user);
				return "albums.jsp";
			}
			return "redirect:/";
		}

		// New Album Page
		@GetMapping("/albums/new")
		public String index(@ModelAttribute("newAlbum") Album Album) {
			//Get User from session and pass it in model
			return "new.jsp";
		}
		// Create Album
		@PostMapping("/albums/create")
		public String create(@Valid @ModelAttribute("newAlbum") Album Album, BindingResult result) {
			if (result.hasErrors()) {
				return "new.jsp";
			} else {
				
				Album newProject = aService.createAlbum(Album);
				return "redirect:/albums";
			}
			
		}
		
		// Get One Album details
				@GetMapping("/albums/album/{id}")
				public String project(@PathVariable("id") Long albumId, Model model, HttpSession session,@ModelAttribute("newRating") Rating rating ) {
					Album album = aService.getOneAlbum(albumId);
					model.addAttribute("album", album);
					model.addAttribute("userLoggedIn",(Long)session.getAttribute("userId"));
					
					
					return "album.jsp";
				}

				

		// Delete Project
		@GetMapping("/albums/delete/{id}")
		private String deleteProject(@PathVariable("id") Long id) {
			aService.deleteAlbum(id);
			return "redirect:/albums";
		}

		// Edit- Page
		@GetMapping("/albums/edit/{id}")
		public String edit(@PathVariable("id") Long id, @ModelAttribute("editedAlbum") Album album, Model model,
				HttpSession session) {
			Album editAlbum = aService.getOneAlbum(id);
			model.addAttribute("editAlbum", editAlbum);
			return "edit.jsp";
		}

		// Update project
		@PostMapping("/albums/update/{id}")
		public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("editedAlbum") Album album,
				BindingResult result, Model model) {
			if (result.hasErrors()) {
				Album editAlbum = aService.getOneAlbum(id);
				model.addAttribute("editAlbum", editAlbum);
				return "edit.jsp";
			} else {
				Album newAlbum = aService.updateAlbum(id, album.getAlbumName(), album.getDescription());
				return "redirect:/albums";

			}
		}

//		Add rating - /albums/rateAlbum/
		@PostMapping("/albums/rateAlbum")
		public String rate( @Valid @ModelAttribute("newRating") Rating  rating,
				BindingResult result) {
		
				aService.addRating(rating);
				return "redirect:/albums";

			
		}
		

	
}
