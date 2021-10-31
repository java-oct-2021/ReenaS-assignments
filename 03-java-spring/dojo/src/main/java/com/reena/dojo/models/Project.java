package com.reena.dojo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 
	private String projectName;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="student_id")
	    private Student student;

	   @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "likes", 
	        joinColumns = @JoinColumn(name = "project_id"), 
	        inverseJoinColumns = @JoinColumn(name = "student_id")
	    )
	    private List<Student> likers;
	   
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public List<Student> getLikers() {
		return likers;
	}

	public void setLikers(List<Student> likers) {
		this.likers = likers;
	}



}
