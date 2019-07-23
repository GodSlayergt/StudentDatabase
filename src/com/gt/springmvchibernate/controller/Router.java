package com.gt.springmvchibernate.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gt.springmvchibernate.Student.Student;
import com.gt.springmvchibernate.dao.DAO;

@Controller
public class Router {
	
	@Autowired
	private DAO dao;
	@RequestMapping("/")
	public String test(Model model) 
	{
		List<Student> sts=dao.getStudents();
		model.addAttribute("students", sts);
		return("home");
		
	}
	
	
	@RequestMapping("/add")
	public String add(@RequestParam(name="id",defaultValue = "0") int id,Model model)
	{
		Student st=new Student();
		st.setId(id);
		model.addAttribute("student",st);
		return("test");
	}
	
	@RequestMapping("/conformation")
	public String add( @Valid @ModelAttribute("student") Student st,BindingResult result)
	{
		
		if(result.hasErrors())
			return ("add");
		dao.addStudent(st);
		return ("redirect:/");
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id)
	{
		System.out.println(id);
		dao.deleteStudent(id);
		return ("redirect:/");
	}
	

}
