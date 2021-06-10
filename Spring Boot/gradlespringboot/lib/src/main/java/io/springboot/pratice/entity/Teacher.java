package io.springboot.pratice.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Teacher {
	
	@NotNull
	private int id;
	@NotNull
	@Size(min=3, message="First Name Should Contain at least 3 character")
	private String firstName;
	@NotNull
	@Size(min=3, message="Last Name Should Contain at least 3 character")
	private String lastName;
	@NotNull
	private String[] subjects;
	private String jobType;
	
	public Teacher()
	{
		
	}
	
	public Teacher(int id,String firstName, String lastName, String[] subjects, String jobType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.subjects = subjects;
		this.jobType = jobType;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public String[] getSubjects() {
		return subjects;
	}
	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	
}
