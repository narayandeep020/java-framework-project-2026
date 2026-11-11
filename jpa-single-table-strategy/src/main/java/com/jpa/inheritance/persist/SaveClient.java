package com.jpa.inheritance.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.inheritance.entity.NonTechstaff;
import com.jpa.inheritance.entity.Techstaff;

public class SaveClient {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-Advanced");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		// Tech staff entity
		Techstaff ts1 = new Techstaff(1, "Gopal", "B.Tech", "Java");
		Techstaff ts2 = new Techstaff(2, "Manisha", "M.Tech", "Data Science");

		// Non-Tech staff entity
		NonTechstaff nts1 = new NonTechstaff(3, "Satish", "Accounts");
		NonTechstaff nts2 = new NonTechstaff(4, "Krishna", "Office Admin");

		em.persist(ts1);
		em.persist(ts2);
		em.persist(nts1);
		em.persist(nts2);
		em.getTransaction().commit();
		
		System.out.println("Data written success.");

		em.close();
		emf.close();
	}

}
