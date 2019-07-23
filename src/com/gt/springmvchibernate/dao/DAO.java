package com.gt.springmvchibernate.dao;

import java.util.List;

import com.gt.springmvchibernate.Student.Student;

public interface DAO {
	
	//Get all the students from database
	public List<Student> getStudents();
	
	//Get a student
	public Student getStudent(int id);
	
	//Add student
	public void addStudent(Student st);
	
	//Delete student
	public void deleteStudent(int id);
	
	
}
