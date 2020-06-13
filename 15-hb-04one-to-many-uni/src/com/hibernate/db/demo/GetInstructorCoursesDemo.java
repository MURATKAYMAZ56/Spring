package com.hibernate.db.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entitiy.Course;
import com.hibernate.demo.entitiy.Instructor;
import com.hibernate.demo.entitiy.InstructorDetail;
import com.hibernate.demo.entitiy.Student;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();
		try {

			// start a transaction

			session.beginTransaction();

			// get the indtructor from db

			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Instructor: " + tempInstructor);

			// get course for instructor
			System.out.println("Courses: " + tempInstructor.getCourses());
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}

}
