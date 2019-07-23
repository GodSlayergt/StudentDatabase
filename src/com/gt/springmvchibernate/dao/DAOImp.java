package com.gt.springmvchibernate.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gt.springmvchibernate.Student.Student;

@Repository
@Transactional
public class DAOImp implements DAO {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Student> getStudents() {

		Session session=factory.getCurrentSession();
		  Query<Student> query=session.createQuery("from Student",Student.class);
          List<Student> list= query.getResultList();
		return list;
	}

	@Override
	public Student getStudent(int id) {
		Session session=factory.getCurrentSession();
		Student st=session.get(Student.class, id);
		return st;
	}

	@Override
	public void addStudent(Student st) {
		Session session=factory.getCurrentSession();
		session.saveOrUpdate("Student",st);
		

	}

	@Override
	public void deleteStudent(int id) {
		Session session=factory.getCurrentSession();
		Query query=session.createQuery("delete from Student where id=:id");
	    query.setParameter("id", id);
	    query.executeUpdate();
	    
	}

	

}
