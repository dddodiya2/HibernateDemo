package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learning.config.AppConfiguration;
import com.learning.entity.Course;
import com.learning.entity.ProjectModules;
import com.learning.entity.StudentEntity;

public class MyApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		SessionFactory sessionFactory = context.getBean(SessionFactory.class);

		// Get the current Session
		Session session = sessionFactory.getCurrentSession();

		
		try {
		
		// Started the transaction
		session.getTransaction().begin();

		// Demo of OneToOne bidirectional mapping
		/*
		 * StudentDetails sd1 = session.get(StudentDetails.class, 2);
		 * System.out.println(sd1); System.out.println(sd1.getStudent());
		 */

		// Demo for OneToMany bi-directional OneToMany mapping
		/*
		 * StudentEntity s1 = session.get(StudentEntity.class, 6);
		 * System.out.println("Name of Student is " + s1.getName());
		 * System.out.println("Project : " + s1.getProjects());
		 * 
		 * 
		 * List<Project> projectsS1 = s1.getProjects(); Project p1OfS1 = new
		 * Project("Ram Spring MVC"); p1OfS1.setStudent(s1); Project p2OfS1 = new
		 * Project("Ram Spring JDBC"); p2OfS1.setStudent(s1);
		 * 
		 * projectsS1.add(p1OfS1); projectsS1.add(p2OfS1);
		 * 
		 * System.out.println("After adding:"); System.out.println("Project : " +
		 * s1.getProjects());
		 * 
		 * //session.save(s1); session.persist(s1);
		 */

		// Fetching StudentEntity using Project
		/*
		 * Project p1 = session.get(Project.class, 2);
		 * 
		 * System.out.println("Project fetched :" + p1.getTitle());
		 * 
		 * System.out.println(p1);
		 * 
		 * StudentEntity s1OfP1 = p1.getStudent();
		 * System.out.println("S1OfP1 is fetched"); System.out.println(s1OfP1);
		 */

		/// Some extra on fetching types :- eager and lazy

		// OneToMany default fetch = LAZY
		/*
		 * List<StudentEntity> students =
		 * session.createQuery("from StudentEntity where branch = 'IT'").getResultList()
		 * ;
		 * 
		 * System.out.println("Fetching the student completed");
		 * 
		 * System.out.println(students);
		 */

		// ManyToOne default fetch = EAGER
		/*
		 * List<Project> projects =
		 * session.createQuery("from Project where title like '%Ram%' ").getResultList()
		 * ;
		 * 
		 * System.out.println("Projects are fetched");
		 * 
		 * System.out.println(projects);
		 */

		// OneToOne fetch demo
		
		/*
		 * StudentEntity s7 = session.get(StudentEntity.class, 7);
		 * 
		 * System.out.println("StudentEntity fetched");
		 * 
		 * System.out.println(s7.getStudentDetails());
		 */

		///Many to Many relation create
		StudentEntity s1 = session.get(StudentEntity.class, 6);
		
		Course c1 = new Course("ENGG_MECH", 9);
		Course c2 = new Course("CPP", 8);
		Course c3 = new Course("ED", 7);
		Course c4 = new Course("CHEM", 9);
		
		s1.getCourses().add(c1);
		s1.getCourses().add(c2);
		s1.getCourses().add(c3);
		session.persist(s1);
		System.out.println("Student s1 saved in DB");
		
		StudentEntity s2 = session.get(StudentEntity.class, 3);
		s2.getCourses().add(c3);
		s2.getCourses().add(c4);
		session.persist(s2);
		
		//Create a new student with student details and projects ateleast (5) 
		//and ProdjectModules(for each atleast 2) and courses and save it
		/*Assignment*/
		// Commit the transaction
		session.getTransaction().commit();

		}
		catch (Exception e) {
			System.out.println("Exception occured : " + e.getMessage());
		}
		finally{
			session.close();
			sessionFactory.close();
			context.close();
		}
	}

}
