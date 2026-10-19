package org.JPQL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.model.Product;

public class JPQLExample {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaOrmDemo");
		EntityManager em = emf.createEntityManager();

		// Insert data
		em.getTransaction().begin();
		Product product = new Product();
		product.setName("OppoMobile");
		product.setPrice(20999);
		em.persist(product);
		em.getTransaction().commit();

		// Read data
		List<Product> read = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
		for (Product p : read) {
			System.out.println(p);
		}

		// Update data
		em.getTransaction().begin();

		int update = em.createQuery("UPDATE Product p SET p.price = :price WHERE p.id = :id")
				.setParameter("price", 60000.0)
				.setParameter("id", 1L)
				.executeUpdate();

		em.getTransaction().commit();
		System.out.println(update);

		// Delete data
		em.getTransaction().begin();

		int deleted = em.createQuery("DELETE FROM Product p WHERE p.name = :name")
				.setParameter("name", "Laptop")
				.executeUpdate();

		em.getTransaction().commit();
		System.out.println(deleted);

		em.close();
		emf.close();
	}

}
