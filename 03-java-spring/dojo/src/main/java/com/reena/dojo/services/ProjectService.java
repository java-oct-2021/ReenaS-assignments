package com.reena.dojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reena.dojo.models.Project;
import com.reena.dojo.models.Student;
import com.reena.dojo.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;
	//List all project	
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	//Create Project	
	public Project createProject(Project newProject) {
		return this.projectRepo.save(newProject);
	}
	//One Project Detail	
		public Project findProject(Long id) {
			return projectRepo.findById(id).orElse(null);
		}
		
	// Add Likes 
		public void AddLikes(Project project, Student student) {
			List<Student> myLikers=project.getLikers();
			myLikers.add(student);
			projectRepo.save(project);
		}
}
