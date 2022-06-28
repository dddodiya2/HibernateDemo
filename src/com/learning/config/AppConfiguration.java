package com.learning.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.learning.entity.Project;
import com.learning.entity.StudentDetails;
import com.learning.entity.StudentEntity;

@Configuration
@ComponentScan("com.learning")
public class AppConfiguration {

	// Create Configuration class
	@Bean
	public SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(StudentEntity.class)
				.addAnnotatedClass(StudentDetails.class)
				.addAnnotatedClass(Project.class)
				.buildSessionFactory();
		return sessionFactory;
	}

}
