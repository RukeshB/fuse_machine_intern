package io.springboot.pratice.entity;

import lombok.Data;

@Data
public class StudentEntity {
 private int id;
 private String firstName;
 private String lastName;
 private String gender;
 private int rollNo;
 private int classNo;
 
 public StudentEntity()
 {
	 
 }
 
public StudentEntity(int id,String firstName, String lastName, String gender, int rollNo, int classNo) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.rollNo = rollNo;
	this.classNo = classNo;
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public int getClassNo() {
	return classNo;
}
public void setClassNo(int classNo) {
	this.classNo = classNo;
}
}
