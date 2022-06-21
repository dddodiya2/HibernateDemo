package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.config.AppConfiguration;
import com.learning.entity.StudentEntity;

public class MyApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);

		// Get the current Session
		Session session = sessionFactory.getCurrentSession();

		// Started the transaction
		session.getTransaction().begin();

		// StudentEntity s1 = new StudentEntity("Karan", "EN", 2021, "17-5-2001");
		// StudentEntity s2 = new StudentEntity("Rahul", "ME", 2021, "26-7-2001");
		// Save objects into db
		// session.save(s1);
		// session.save(s2);

		// StudentEntity s1 = session.get(StudentEntity.class, 3);
		// System.out.println("Before update of : " + s1 );
		// s1.setBranch("CS");
		// System.out.println("after update of : " + s1 );

		// StudentEntity s2 = session.get(StudentEntity.class, 4);
		// System.out.println("Before update of : " + s1 );
		// s2.setBranch("IT");
		// System.out.println("after update of : " + s1 );

		// Save objects into db
		// session.save(s1);
		// session.save(s2);

		// HQL sql - select * from Student ---> (HQL) --> from StudentEntity
		// List<StudentEntity> studentsList = session.createQuery("from
		// StudentEntity").getResultList();

		// System.out.println(studentsList);

		StudentEntity s3 = new StudentEntity("Rahul", "IT", 2021, "10-5-2001");
		s3.setId(5);
		System.out.println("Before : " + s3);
		session.saveOrUpdate(s3);   ///   5 Rahul IT 2021 10-5-2021

		
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();

		context.close();
	}

}
