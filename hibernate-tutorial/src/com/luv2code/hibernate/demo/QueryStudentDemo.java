package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure()
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			// query the students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			// display the students
			displayStudents(theStudents);
			
			//query students: firstName = "Ashraful"
			theStudents = session.createQuery("from Student s where s.firstName = 'Ashraful'").list();
			
			// display the students
			System.out.println("\n\nStudents who have first name of Ashraful:");
			displayStudents(theStudents);
			
			// query students: lastName = 'Talukder' or firstName='Chayan'
			theStudents = session.createQuery("from Student s where s.lastName = 'Talukder' OR s.firstName = 'Chayan'").list();
			
			// display the students
			System.out.println("\n\nStudents who have first name of Chayan or last name of Talukder:");					
			displayStudents(theStudents);
			
			// query students: like query
			theStudents = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").list();
			
			// display the students
			System.out.println("\n\nStudents who have email ends with @gmail.com:");					
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
