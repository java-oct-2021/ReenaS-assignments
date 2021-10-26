package com.reena.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reena.dojo.models.Project;

@Repository
public interface ProjectRepository  extends CrudRepository<Project, Long>{
	// this method retrieves all the students from the database
    List<Project> findAll();

}
