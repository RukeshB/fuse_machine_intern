package io.springboot.pratice.entity;

public class Teachers {
	private int id;
	private String firstName;
	private String lastName;
	private String[] subjects;
	private String jobType;
	
	public Teachers()
	{
		
	}
	
	public Teachers(int id,String firstName, String lastName, String[] subjects, String jobType) {
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
