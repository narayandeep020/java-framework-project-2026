package org.JPQL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ScalarFunction {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();

		// Scalar function
		Query query = em.createQuery("SELECT UPPER(s.stuName) FROM Student s");
		List<String> result = query.getResultList();
		for (String s : result) {
			System.out.println("Student Name: " + s);
		}

	}

}
// Scalar functions return resultant values based on input values.
//For example, Upper() function returns the passed column value in upper case.
