package org.JPQL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AggregateFunction {

	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager emanager = emfactory.createEntityManager();

		// Aggregate function
		Query query = emanager.createQuery("SELECT MAX(p.price) FROM Product p");
		double result = (double) query.getSingleResult();
		System.out.println("Max Product Price: " + result);

		
		Long count = emanager.createQuery("SELECT COUNT(s) FROM Student s WHERE s.city = :city", Long.class)
				.setParameter("city", "katni").getSingleResult();
		System.out.println(count);

	}

}
//Aggregations → count(), avg(), sum(), max(), min()