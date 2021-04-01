package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			Instructor tempInstrutor = new Instructor("Samiullah", "Hossain", "tsami@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com/hossain-sami", "Swimming");
			
			// associate the objects
			tempInstrutor.setInstructionDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			System.out.println("Saving instructor: "  + tempInstructorDetail);
			System.out.println("Saving instructor: "  + tempInstrutor);
			session.save(tempInstrutor);	// this will also save the details object because of "CascadeType.ALL"
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}