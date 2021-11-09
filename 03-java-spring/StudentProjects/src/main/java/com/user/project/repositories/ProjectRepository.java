package com.user.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.user.project.models.Project;


public interface ProjectRepository  extends CrudRepository<Project, Long> {

	// Create
	// Read
	// Update
	// Delete
	
	List<Project> findAll(); 


	
}
