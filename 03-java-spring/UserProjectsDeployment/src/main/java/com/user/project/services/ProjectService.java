package com.user.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.project.models.Project;
import com.user.project.models.User;
import com.user.project.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	// List all projects
	public List<Project> allProjects() {
//		return projectRepo.findAll();
		//return projectRepo.findAllByOrderByProjectNameDesc();
		//return projectRepo.findDistinctByOrderByLikersDesc();
//		return projectRepo.findAllProjects();
		return projectRepo.findAllprojectsNative();
	}

	// Create new project
	public Project createProject(Project project) {
		System.out.println("Creating a project");
		return projectRepo.save(project);
	}

	// Delete a Project
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}

	// Get One project
	public Project getOneProject(Long id) {
		return projectRepo.findById(id).orElse(null);
	}

	// Update project
	public Project updateProject(Long id, String name, String description) {
		Project project = getOneProject(id);
		project.setProjectName(name);
		project.setDescription(description);
		return projectRepo.save(project);

	}

	// Like a project
	public void likeProject(Project project, User user) {
		List<User> likers = project.getLikers();
		likers.add(user);
		projectRepo.save(project);

	}
	// Unlike Project
	public void unLikeProject(Project project, User user) {
//		Logic
		List<User> likers = project.getLikers();
		likers.remove(user);
		projectRepo.save(project);


	}

}
