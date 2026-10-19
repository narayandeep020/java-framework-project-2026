package org.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.model.Course;

public class CourseImpl {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();
		
		// Insert data
		em.getTransaction().begin();
		Course course = new Course();
		course.setCid(5);
		course.setCname("B.A");
		course.setFees(30000);
		em.persist(course);
		em.getTransaction().commit();
		
		//Read data
		Course retrive = em.find(Course.class, 5);
		System.out.println(retrive.getCname());
		
		//Update data
		em.getTransaction().begin();
		retrive.setCname("BBA");
		em.getTransaction().commit();
		
		//Delete data 
		em.getTransaction().begin();
		em.remove(retrive);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
