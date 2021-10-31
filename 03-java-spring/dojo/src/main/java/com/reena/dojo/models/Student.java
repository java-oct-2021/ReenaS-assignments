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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
    @Size(min = 2, max = 200, message="Dummy, First Name should be between 2-200")
	private String firstName;
	private String lastName;
	@NotNull
    @Size(min = 2, max = 20, message="Email should be between 2-20")
	private String email;
	
	@OneToMany(mappedBy="student", fetch = FetchType.LAZY)
    private List<Project> projects;
	
	   @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "likes", 
	        joinColumns = @JoinColumn(name = "student_id"), 
	        inverseJoinColumns = @JoinColumn(name = "project_id")
	    )
	    private List<Project> projectLiked;
	   
	   
	
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public List<Project> getProjectLiked() {
		return projectLiked;
	}
	public void setProjectLiked(List<Project> projectLiked) {
		this.projectLiked = projectLiked;
	}
	
	
}
