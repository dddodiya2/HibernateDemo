package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.config.AppConfiguration;
import com.learning.entity.StudentDetails;
import com.learning.entity.StudentEntity;

public class MyApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);

		// Get the current Session
		Session session = sessionFactory.getCurrentSession();

		// Started the transaction
		session.getTransaction().begin();
		
		//Saving an entity having one to one relationship
		
		/*
		StudentEntity s1 = new StudentEntity("Johny", "ME", 2019, "15-7-1999");
		StudentDetails sd1 = new StudentDetails("Johny.johny@gmail.com", "1234567890");
		s1.setStudentDetails(sd1);
		session.save(s1);
		
		StudentEntity s5 = new StudentEntity("Ram", "IT", 2018, "15-7-2000");
		StudentDetails sd5 = new StudentDetails("Ram.ram@gmail.com", "12340000090");
		s5.setStudentDetails(sd5);
		session.save(s5);
		*/
		
		//Updating an entity having one to one relationship
		/*
		int std_id = 4;
		StudentEntity s2 = session.get(StudentEntity.class, std_id);
		s2.setDateOfBirth("19-08-2001");
		StudentDetails sd2 = s2.getStudentDetails();
		sd2.setContact("9874561230");
		session.saveOrUpdate(s2);
		*/
		
		//Deleting an entity having one to one relationship
		int std_id4 = 4;
		StudentEntity s4 = session.get(StudentEntity.class, std_id4);
		session.delete(s4);
		
		
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();

		context.close();
	}

}
