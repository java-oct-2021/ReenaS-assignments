package com.reena.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reena.dojo.models.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Long>{
	// this method retrieves all the students from the database
    List<Student> findAll();

}
