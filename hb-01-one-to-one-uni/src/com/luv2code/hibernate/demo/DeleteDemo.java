package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId = 2;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Found instrutor: " + tempInstructor);
			
			
			// delete the instructors
			if(tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);
				session.delete(tempInstructor); // this also delete associate tables value because of "Cascade.ALL"
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}